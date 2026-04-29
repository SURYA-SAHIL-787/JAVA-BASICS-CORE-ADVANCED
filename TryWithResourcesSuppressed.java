class DemoResource implements AutoCloseable {
    public void use() {
        throw new RuntimeException("Exception inside use()");
    }

    @Override
    public void close() {
        throw new RuntimeException("Exception inside close()");
    }
}

public class TryWithResourcesSuppressed {
    public static void main(String[] args) {
        try (DemoResource resource = new DemoResource()) {
            resource.use();
        } catch (RuntimeException e) {
            System.out.println("Main: " + e.getMessage());

            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }
}
