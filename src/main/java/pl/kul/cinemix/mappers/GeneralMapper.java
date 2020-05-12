package pl.kul.cinemix.mappers;

/**
 * General mapping interface created for mapping DTOs to Entities and vice versa.
 * Maybe its better to use some ready mappers on internet.
 * Its temporary solution.
 *
 * @param <T> the type of DTO
 * @param <U> the type of Entity
 *
 * @author  Josh Bloch
 */
public interface GeneralMapper<T, U> {
    T mapToDto(U entity);
    U mapToEntity(T dto);
}
