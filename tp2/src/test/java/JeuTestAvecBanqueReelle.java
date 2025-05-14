import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JeuTestAvecBanqueReelle {
    private BanqueImpl banque;
    @Mock
    private Joueur joueur;
    @Mock
    private De de1;
    @Mock
    private De de2;

    private Jeu jeu;

    @Before
    public void setUp() {
        // Initialisation avec un fond de 1000 et un minimum de 500
        banque = new BanqueImpl(1000, 500);
        jeu = new Jeu(banque);
    }

    @Test
    public void testJouerQuandJoueurGagneAvecBanqueReelle() throws JeuFermeException, DebitImpossibleException {
        // Configuration
        when(joueur.mise()).thenReturn(300);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);

        // Vérification du fond initial
        assertEquals(1000, banque.getFond());

        // Action
        jeu.jouer(joueur, de1, de2);

        // Vérifications
        verify(joueur).mise();
        verify(joueur).debiter(300);
        verify(joueur).crediter(600);

        // Vérification de l'état réel de la banque
        assertEquals(700, banque.getFond());
        assertTrue(banque.est_solvable());
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testJouerQuandBanqueDevenirInsolvalbeAvecBanqueReelle() throws JeuFermeException, DebitImpossibleException {
        // Configuration
        when(joueur.mise()).thenReturn(300);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);

        // Premier gain qui rend la banque insolvable
        jeu.jouer(joueur, de1, de2);

        // Vérification après le premier jeu
        assertEquals(700, banque.getFond());
        assertTrue(banque.est_solvable());
        assertTrue(jeu.estOuvert());

        // Deuxième gain qui fait passer sous le seuil minimum
        jeu.jouer(joueur, de1, de2);

        // Vérifications
        assertEquals(400, banque.getFond());
        assertFalse(banque.est_solvable());
        assertFalse(jeu.estOuvert());
    }
} 