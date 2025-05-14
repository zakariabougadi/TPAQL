import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JeuTest {
    @Mock
    private Banque banque;
    @Mock
    private Joueur joueur;
    @Mock
    private De de1;
    @Mock
    private De de2;

    private Jeu jeu;

    @Before
    public void setUp() {
        jeu = new Jeu(banque);
    }

    @Test(expected = JeuFermeException.class)
    public void testJouerQuandJeuFerme() throws JeuFermeException {
        // Test d'état : on vérifie que le jeu lance bien l'exception quand il est fermé
        jeu.fermer();
        jeu.jouer(joueur, de1, de2);
    }

    @Test
    public void testJouerQuandJoueurInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Test d'interactions : on vérifie que le jeu ne touche pas aux dés quand le joueur est insolvable
        when(joueur.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Insolvable")).when(joueur).debiter(100);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).mise();
        verify(joueur).debiter(100);
        verifyNoInteractions(de1, de2);
        verifyNoMoreInteractions(joueur);
    }

    @Test
    public void testJouerQuandJoueurPerd() throws JeuFermeException, DebitImpossibleException {
        // Configuration
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(2);

        // Action
        jeu.jouer(joueur, de1, de2);

        // Vérification
        verify(joueur).mise();
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verifyNoMoreInteractions(joueur, banque);
    }

    @Test
    public void testJouerQuandJoueurGagne() throws JeuFermeException, DebitImpossibleException {
        // Configuration
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        when(banque.est_solvable()).thenReturn(true);

        // Action
        jeu.jouer(joueur, de1, de2);

        // Vérification
        verify(joueur).mise();
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        verify(banque).est_solvable();
        verifyNoMoreInteractions(joueur, banque);
    }

    @Test
    public void testJouerQuandBanqueDevientInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Configuration
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        when(banque.est_solvable()).thenReturn(false);

        // Action
        jeu.jouer(joueur, de1, de2);

        // Vérification
        verify(joueur).mise();
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        verify(banque).est_solvable();
        assertFalse(jeu.estOuvert());
    }
}