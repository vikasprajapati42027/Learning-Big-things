// Note: Requires Testcontainers dependency
/*
@Testcontainers
class Test14_RedisTest {
    @Container
    public static GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:alpine"))
            .withExposedPorts(6379);

    @Test
    void testRedisConnection() {
        String address = redis.getHost();
        Integer port = redis.getMappedPort(6379);
        // Use these to connect in your test!
        assertTrue(redis.isRunning());
    }
}
*/
