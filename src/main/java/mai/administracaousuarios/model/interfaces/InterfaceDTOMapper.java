package mai.administracaousuarios.model.interfaces;

public interface InterfaceDTOMapper<Entity, DTO> {
    void toEntity(DTO dto, Entity entity);
}
