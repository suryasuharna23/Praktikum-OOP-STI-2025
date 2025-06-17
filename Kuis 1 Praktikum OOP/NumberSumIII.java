/**
 * Nama : Darryl Rayhananta Adenan
 * NIM  : 18223042
 */

public class NumberSumIII {
    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length]; // array keluaran
        int index = 0; 

        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan

        // mengisi array result yang tersisa dengan null

        for (int i = 0; i < numbers.length; i++) {
            Class<?> currentType = numbers[i].getClass();
            boolean cek = false;
            for (int k = 0; k < i; k++) {
                if (numbers[k].getClass().equals(currentType)) {
                    cek = true;
                    break;
                }
            }
            if (!cek) {
                java.util.ArrayList<Number> list = new java.util.ArrayList<>();
                for (int j = i; j < numbers.length; j++) {
                    if (numbers[j].getClass().equals(currentType)) {
                        list.add(numbers[j]);
                    }
                }
                
                Number operationResult = list.get(0);
                boolean tambah = true;
                boolean kurang = false;
                boolean kali = false;
                for (int m = 1; m < list.size(); m++) {
                    if (tambah) {
                        operationResult = add(operationResult, list.get(m));
                        tambah = false;
                        kurang = true;
                    } else if (kurang) {
                        operationResult = subtract(operationResult, list.get(m));
                        kurang = false;
                        kali = true;
                    } else if (kali) {
                        operationResult = multiply(operationResult, list.get(m));
                        kali = false;
                        tambah = true;
                    }
                }

                result[index++] = operationResult;
            }
        }
        
        while (index < result.length) {
            result[index++] = null;
        }
        
        return result;
    } 

    private static Number add(Number a, Number b) {
        // lakukan operasi penjumlahan sesuai tipe data
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
        }
        return null;
    }

    private static Number subtract(Number a, Number b) {
        // lakukan operasi pengurangan sesuai tipe data
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
        }
        return null;
    }

    private static Number multiply(Number a, Number b) {
        // lakukan operasi perkalian sesuai tipe data
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
        }
        return null;
    }
}
