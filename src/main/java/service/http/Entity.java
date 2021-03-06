package service.http;


public class Entity<T> {

    private T entity;

    private String contentType;

    public static <T> Entity<T> json(T entity) {
        return new Entity<T>(entity, "application/json");
    }

    public static <T> Entity<T> stream(T entity) {
        return new Entity<T>(entity, "application/octet-stream");
    }

    public static <T> Entity<T> yaml(T entity) {
        return new Entity<T>(entity, "application/x-yaml");
    }

    public Entity(T entity, String contentType) {
        super();
        this.entity = entity;
        this.contentType = contentType;
    }

    /**
     * @return the entity
     */
    public T getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
