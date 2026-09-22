import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.insw.Searcher;

public class SearcherTestCase {

    private Searcher searcher;

    @BeforeEach
    void setUp() {
        this.searcher = new Searcher();
    }

    //// SEARCH WORD
    /// La palabra existe
    @Test
    void testSearchWord() {
        List<String> imports = List.of("Perro", "Gato", "Conejo", "Pez");
        boolean result = searcher.searchWord("Gato", imports);
        assertEquals(true, result);
    }

    /// La palabra no existe
    @Test
    void testSearchWordNo() {
        List<String> imports = List.of("Perro", "Gato", "Conejo", "Pez");
        boolean result = searcher.searchWord("Tortuga", imports);
        assertEquals(false, result);
    }

    //// GET WORD BY INDEX
    /// Indice válido
    @Test
    void testGetWordByIndex() {
        List<String> imports = List.of("Perro", "Gato", "Conejo", "Pez");
        String result = searcher.getWordByIndex(imports, 1);
        assertEquals("Gato", result);
    }

    /// Indice no válido
    @Test
    void testGetWordByIndexInvPos() {
        List<String> imports = List.of("Perro", "Gato", "Conejo", "Pez");
        String result = searcher.getWordByIndex(imports, 5);
        assertEquals(null, result);
    }

    @Test
    void testGetWordByIndexInvNeg() {
        List<String> imports = List.of("Perro", "Gato", "Conejo", "Pez");
        String result = searcher.getWordByIndex(imports, -5);
        assertEquals(null, result);
    }

    //// SEARCH BY PREFIX
    /// Palabras que empiezan por el prefijo
    @Test
    void testSearchByPrefix() {
        List<String> imports = List.of("apple", "application", "apply", "banana", "band", "car");
        List<String> result = searcher.searchByPrefix("app", imports);

        List<String> words = List.of("apple", "application", "apply");
        assertEquals(words, result);

    }

    /// Palabras que no empiezan por el prefijo
    @Test
    void testSearchByPrefixNot() {
        List<String> imports = List.of("apple", "application", "apply", "banana", "band", "car");
        List<String> result = searcher.searchByPrefix("pre", imports);

        List<String> words = List.of();
        assertEquals(words, result);

    }

    //// FILTER BY KEYWORD
    /// Elementos con la palabra clave

    @Test
    void testFilterByKeword() {
        List<String> imports = List.of("Esto es una prueba", "Hoy es lunes", "Seguro que funciona");
        List<String> result = searcher.filterByKeyword("es", imports);

        List<String> keyword = List.of("Esto es una prueba", "Hoy es lunes");

        assertEquals(keyword, result);

    }

    /// No existe la palabra clave
    @Test
    void testFilterByKewordNot() {
        List<String> imports = List.of("Esto es una prueba", "Hoy es lunes", "Seguro que funciona");
        List<String> result = searcher.filterByKeyword("hola", imports);

        List<String> keyword = List.of();

        assertEquals(keyword, result);

    }

    //// SEARCH EXACT PHRASE
    /// Fallo: al tener un else dentro del bucle, si el primer elemento de la lista
    //// no es el que estamos buscando, directamente
    /// devuelve falso sin comprobar el resto. Por lo tanto, el "return false" debe
    //// de ir fuera del bucle de tal forma que si
    /// termina el bucle sin haber devuelto nada, significará que la frase no está y
    //// devuelve "false".

    /// Existe la frase
    @Test
    void testSearchExactPhrase() {
        List<String> imports = List.of("Esto es una prueba", "Hoy es lunes", "Seguro que funciona");
        boolean result = searcher.searchExactPhrase("Seguro que funciona", imports);

        assertEquals(true, result);

    }

    /// No existe la frase
    @Test
    void testSearchExactPhraseNot() {
        List<String> imports = List.of("Esto es una prueba", "Hoy es lunes", "Seguro que funciona");
        boolean result = searcher.searchExactPhrase("No existe", imports);

        assertEquals(false, result);

    }

}