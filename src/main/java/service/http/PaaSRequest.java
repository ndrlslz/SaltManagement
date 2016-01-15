package service.http;


import java.util.*;


public class PaaSRequest<R> {

    private PaaSClient client;

    public PaaSRequest() {

    }

    public PaaSRequest(PaaSClient client, HttpMethod method, CharSequence path, Entity<?> entity, Class<R> returnType) {

        this.client = client;
        this.method = method;
        this.path = new StringBuilder(path);
        this.entity = entity;
        this.returnType = returnType;
        if ("application/x-yaml".equals(entity.getContentType())) {
            header("Accept", "application/x-yaml");
        } else {
            header("Accept", "application/json");
        }
    }

    private String managerUrl;

    private HttpMethod method;

    private StringBuilder path = new StringBuilder();

    private Map<String, List<Object>> headers = new HashMap<String, List<Object>>();

    private Entity<?> entity;

    private Class<R> returnType;

    public PaaSRequest<R> managerUrl(String managerUrl) {
        this.managerUrl = managerUrl;
        return this;
    }

    public String managerUrl() {
        return managerUrl;
    }

    public PaaSRequest<R> method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public HttpMethod method() {
        return method;
    }

    public PaaSRequest<R> path(String path) {
        this.path.append(path);
        return this;
    }

    public String path() {
        return path.toString();
    }

    public PaaSRequest<R> header(String name, Object value) {
        if (value != null) {
            headers.put(name, Arrays.asList(value));
        }
        return this;
    }

    public Map<String, List<Object>> headers() {
        return headers;
    }

    public <T> Entity<T> entity(T entity, String contentType) {
        return new Entity<T>(entity, contentType);
    }

    public Entity<?> entity() {
        return entity;
    }

    public <T> Entity<T> json(T entity) {
        return entity(entity, "application/json");
    }

    public void returnType(Class<R> returnType) {
        this.returnType = returnType;
    }

    public Class<R> returnType() {
        return returnType;
    }

    public R execute() {
        return client.execute(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Request [managerUrl=" + managerUrl + ", method=" + method + ", path=" + path + ", headers="
                + headers + ", entity=" + entity + ", returnType=" + returnType + "]";
    }

    private Map<String, List<Object>> queryParams = new LinkedHashMap<String, List<Object>>();

    public Map<String, List<Object>> queryParams() {
        return queryParams;
    }

    public PaaSRequest<R> queryParam(String key, Object value) {
        if (queryParams.containsKey(key)) {
            List<Object> values = queryParams.get(key);
            values.add(value);
        } else {
            List<Object> values = new ArrayList<Object>();
            values.add(value);
            queryParams.put(key, values);
        }

        return this;
    }

    protected static String buildPath(String... elements) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : elements) {
            stringBuilder.append(element);
        }

        return stringBuilder.toString();
    }
}
