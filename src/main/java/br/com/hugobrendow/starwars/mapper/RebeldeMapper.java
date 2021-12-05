package br.com.hugobrendow.starwars.mapper;

import br.com.hugobrendow.starwars.dto.request.LocalizacaoRequest;
import br.com.hugobrendow.starwars.dto.request.RebeldeRequest;
import br.com.hugobrendow.starwars.dto.request.item.CriarItemRequest;
import br.com.hugobrendow.starwars.dto.request.item.ListarItemResponse;
import br.com.hugobrendow.starwars.dto.response.RebeldeResponse;
import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.model.Localizacao;
import br.com.hugobrendow.starwars.model.Rebelde;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RebeldeMapper {
    RebeldeMapper INSTANCE = Mappers.getMapper(RebeldeMapper.class);

    Rebelde rebeldeRequestToRebeldeEntity(RebeldeRequest createRebeldeRequest);
    RebeldeResponse rebeldeEntityToRebeldeResponse(Rebelde rebelde);
    List<RebeldeResponse> rebeldeEntityToRebeldeResponse(List<Rebelde> rebeldes);
    Localizacao localizacaoRequestToLocalizacaoEntity(LocalizacaoRequest localizacaoRequest);
    Item criarItemRequestToItemEntity(CriarItemRequest itemRequest);
    List<ListarItemResponse> itemEntityToListarItemResponse(List<Item> itens);
}
