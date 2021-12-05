package br.com.hugobrendow.starwars.mapper;

import br.com.hugobrendow.starwars.dto.request.CriarRebeldeRequest;
import br.com.hugobrendow.starwars.model.Rebelde;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RebeldeMapper {
    RebeldeMapper INSTANCE = Mappers.getMapper(RebeldeMapper.class);

    Rebelde rebeldeRequestToRebeldeEntity(CriarRebeldeRequest createRebeldeRequest);
}
