import com.google.protobuf.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceScenarioTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateurValidationError() throws ServiceException {
        // Arrange: Create an invalid user
        Utilisateur utilisateur = new Utilisateur("", "", "invalid@email.com");

        // Create the service with the mock
        UserService userService = new UserService(utilisateurApiMock);

        // Act & Assert: Expect ServiceException
        assertThrows(ServiceException.class, () -> userService.creerUtilisateur(utilisateur));

        // Verify no API call
        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    // Other tests (unchanged from previous response)
}