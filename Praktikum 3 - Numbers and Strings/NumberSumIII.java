// Author: Surya Suharna 18223075
public class NumberSumIII {
    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length];
        int index = 0;

        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) continue;
            Number temp = numbers[i];
            int operation = 0; // catatan tipis: 0 = add, 1 = subtract, 2 = multiply
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] != null && numbers[j].getClass().equals(numbers[i].getClass())) {
                    if (operation == 0) temp = add(temp, numbers[j]);
                    else if (operation == 1) temp = subtract(temp, numbers[j]);
                    else temp = multiply(temp, numbers[j]);

                    operation = (operation + 1) % 3;
                    numbers[j] = null; // mark yg udh klar
                }
            }


            
            result[index++] = temp;
        }

        // mengisi array result yang tersisa dengan null
        while (index < numbers.length) {
            result[index++] = null;
        }

        return result;
    }

    private static Number add(Number a, Number b) { // lakukan operasi penjumlahan sesuai tipe data
        if (a instanceof Byte) {
            return (byte) (a.byteValue() + b.byteValue());
        } else if (a instanceof Short) {
            return (short) (a.shortValue() + b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() + b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() + b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else {
            return null;
        }
    }

    private static Number subtract(Number a, Number b) { // lakukan operasi pengurangan sesuai tipe data
        if (a instanceof Byte) {
            return (byte) (a.byteValue() - b.byteValue());
        } else if (a instanceof Short) {
            return (short) (a.shortValue() - b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() - b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() - b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        } else {
            return null;
        }
    }

    private static Number multiply(Number a, Number b) { // lakukan operasi perkalian sesuai tipe data
        if (a instanceof Byte) {
            return (byte) (a.byteValue() * b.byteValue());
        } else if (a instanceof Short) {
            return (short) (a.shortValue() * b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() * b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() * b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() * b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        } else {
            return null;
        }
    }
}
