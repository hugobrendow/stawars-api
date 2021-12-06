package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.dto.request.negocio.NegocioRequest;
import br.com.hugobrendow.starwars.exception.InventarioVazioException;
import br.com.hugobrendow.starwars.exception.ItemInvalidoException;
import br.com.hugobrendow.starwars.exception.RebeldeBloqueadoTransacionarException;
import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.exception.ValoresInvalidosException;
import br.com.hugobrendow.starwars.model.ItemInventario;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NegocioItensService {
    private RebeldeRepository rebeldeRepository;

    public void negociarItens(NegocioRequest negocioRequest) {
        Rebelde negociante = rebeldeRepository.findById(negocioRequest.getRebeldeNegociante().getId()).orElseThrow(() -> new RebeldeNaoEncontradoException());
        Rebelde negociador = rebeldeRepository.findById(negocioRequest.getRebeldeNegociador().getId()).orElseThrow(() -> new RebeldeNaoEncontradoException());

        List<ItemInventario> itensNegociador = negocioRequest.getRebeldeNegociador().getItens();
        List<ItemInventario> itensNegociante = negocioRequest.getRebeldeNegociante().getItens();

        validarValoresNegociacao(negocioRequest);
        validarRebelde(negociador, itensNegociador);
        validarRebelde(negociante, itensNegociante);

        substituirItens(negociador, itensNegociante, itensNegociador);
        substituirItens(negociante, itensNegociador, itensNegociante);
    }

    private void substituirItens(Rebelde rebelde, List<ItemInventario> itensRecebidos, List<ItemInventario> itensDoados) {
        List<ItemInventario> itensRebelde = rebelde.getInventario().getItens();
        itensRebelde.removeIf(item -> itensRecebidos.stream().anyMatch(itemVendido -> item.getItem().getId().equals(itemVendido.getItem().getId())));

        itensRebelde.addAll(itensDoados);
        rebelde.getInventario().setItens(itensRebelde);
        rebeldeRepository.save(rebelde);
    }

    private void validarRebelde(Rebelde rebelde, List<ItemInventario> itens) {
        validarAcusacoes(rebelde);
        validarItensRebelde(rebelde, itens);
    }

    private void validarAcusacoes(Rebelde rebelde) {
        if (rebelde.getAcusacoes() >= 3) {
            throw new RebeldeBloqueadoTransacionarException();
        }
    }

    private void validarItensRebelde(Rebelde rebelde, List<ItemInventario> itens) {
        if (rebelde.getInventario().getItens().isEmpty()) {
            throw new InventarioVazioException();
        }

        boolean disponivelNegociar = itens.stream().anyMatch(itemNegociavel -> {
            Optional<ItemInventario> itemDisponivelParaNegociar = rebelde.getInventario()
                    .getItens()
                    .stream()
                    .filter(rebeldeItem -> rebeldeItem.getItem().getId().equals(itemNegociavel.getId()) &&
                            rebeldeItem.getQuantidade() >= itemNegociavel.getQuantidade()).findFirst();
            return itemDisponivelParaNegociar.isPresent();
        });

        if (!disponivelNegociar) {
            throw new ItemInvalidoException();
        }
    }

    private void validarValoresNegociacao(NegocioRequest negocioRequest) {
        Integer pontosNegociador = negocioRequest.getRebeldeNegociador()
                .getItens()
                .stream().map(item -> item.getQuantidade() * item.getItem().getPontos())
                .reduce(0, (subtotal, valorIndex) -> subtotal + valorIndex);

        Integer pontosNegociante = negocioRequest.getRebeldeNegociante()
                .getItens()
                .stream().map(item -> item.getQuantidade() * item.getItem().getPontos())
                .reduce(0, (subtotal, valorIndex) -> subtotal + valorIndex);

        if (pontosNegociador != pontosNegociante) {
            throw new ValoresInvalidosException();
        }
    }
}
