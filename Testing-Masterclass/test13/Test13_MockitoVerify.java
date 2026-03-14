import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class Test13_MockitoVerify {

    @Test
    void testArgumentCaptor() {
        EmailService mockEmail = mock(EmailService.class);
        UserService service = new UserService(mockEmail);

        service.registerUser("vikas@example.com");

        // 1. Verify method was called once
        verify(mockEmail, times(1)).sendWelcomeEmail(anyString());

        // 2. Capture the actual argument sent to the mock
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockEmail).sendWelcomeEmail(captor.capture());

        assertEquals("vikas@example.com", captor.getValue());
    }
}
