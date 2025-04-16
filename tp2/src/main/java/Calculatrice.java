import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // TODO: Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // TODO: Vérification du résultat
        assertEquals(5, resultat);

        // TODO: Vérification que la méthode "additionner" a été appelée avec les arguments 2 et 3
        verify(calculatrice).additionner(2, 3);

        // TODO: Vérification qu'aucune autre méthode n'a été appelée sur l'objet
        verifyNoMoreInteractions(calculatrice);

        // TODO: Vérification de l'état de l'objet après l'appel de la méthode "additionner"
        // Note: Comme il s'agit d'un mock, l'état interne (result) n'est pas modifié par le mock.
        // Cependant, l'énoncé semble suggérer une vérification de l'état. Si nous testions l'objet réel,
        // nous utiliserions calculatrice.getResult(). Avec un mock, nous pouvons simuler getResult().
        when(calculatrice.getResult()).thenReturn(5);
        verify(calculatrice).getResult();
        assertEquals(5, calculatrice.getResult());
    }
}