import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Arrange: définition du comportement
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Act: appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // Assert: vérification du résultat
        assertEquals(5, resultat);

        // Vérification des interactions
        verify(calculatrice).additionner(2, 3);
        verifyNoMoreInteractions(calculatrice);

        // Vérification de l'état de l'objet après l'appel
        verify(calculatrice).getResult();
    }
}