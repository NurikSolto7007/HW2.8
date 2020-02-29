import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dic = new HashMap<>();
        dic.put("креативный", new String[]{"творческий", "созидательный", "необычный", "оригинальный"});
        dic.put("большой", new String[]{"внушительный", "громадный", "огромный", "крупный"});
        dic.put("любопытный ", new String[]{"Любознательный", "пытливый", "испытующий", "интересный"});
        dic.put("сильный ", new String[]{"крепкий", "могучий", "мощный", "Здоровый"});
        HashMap<String, String[]> bigDictionary = new HashMap();
        Set<String> keys = dic.keySet(); // getting all keys
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] values = dic.get(key);
            bigDictionary.put(key, values); //putting in bigDictionary K & V
            for (int i = 0; i < values.length; i++) {
                String newKey = values[i];
                List<String> val = new ArrayList<>(values.length);      //length will be the same length of values
                val.addAll(Arrays.asList(values));
                val.remove(newKey);
                val.add(key);
                String[] newVal = new String[val.size()];
                newVal = val.toArray(newVal);
                bigDictionary.put(newKey, newVal); } }
        System.out.println("Печатать слово:");
        Scanner scanner = new Scanner(System.in);
        String sentences = scanner.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null) {
                int randomNumber = r.nextInt(synonyms.length);
                System.out.printf(synonyms[randomNumber] + " ");
            } else {
                System.out.println("Здесь нет такого слово! Пробуйте еще раз");
            }
        }
    }
}
