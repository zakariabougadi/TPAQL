import com.google.protobuf.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Arrange: nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du mock: ne lève pas d'exception
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Creation du service
        UserService userService = new UserService(utilisateurApiMock);

        // Act: appel de la méthode
        userService.creerUtilisateur(utilisateur);

        // Assert: vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
        verifyNoMoreInteractions(utilisateurApiMock);
    }
}