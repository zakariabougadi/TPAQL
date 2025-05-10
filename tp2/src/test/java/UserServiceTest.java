import com.google.protobuf.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        
        // Configuration du mock
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        
        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        
        // Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    @Test(expected = ServiceException.class)
    public void testCreerUtilisateurAvecException() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        
        // Configuration du mock pour lever une exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
            .when(utilisateurApiMock).creerUtilisateur(utilisateur);
        
        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode qui devrait lever une exception
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateurAvecId() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        
        // Configuration du mock pour simuler l'attribution d'un ID
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0);
            u.setId(123);
            return null;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);
        
        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        
        // Vérification de l'ID de l'utilisateur
        assertEquals(123, utilisateur.getId());
    }

    @Test
    public void testCreerUtilisateurAvecArgumentCaptor() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        
        // Création du captor d'arguments
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        
        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        
        // Capture et vérification des arguments
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        
        assertEquals("Jean", utilisateurCapture.getNom());
        assertEquals("Dupont", utilisateurCapture.getPrenom());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
    }
}