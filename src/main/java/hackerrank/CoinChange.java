package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    static int can_give_change(List<Integer> rupee_notes) {
        int _5 = 0;
        int _10 = 0;

        for (int i = 0; i < rupee_notes.size(); i++) {
            int note = rupee_notes.get(i);
            if (note == 5) {
                _5++;
            } else if (note == 10) {
                if (_5 > 0) {
                    _5--;
                    _10++;
                } else {
                    return i+1;
                }
            } else if (note == 20) {
                if (_10 > 0) {
                    _10--;
                    if (_5 > 0) {
                        _5--;
                    } else {
                        return i+1;
                    }
                } else if (_5 > 2) {
                    _5 -= 3;
                }
                else {
                    return i+1;
                }
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(20);
        list.add(10);
        list.add(10);




        System.out.println(can_give_change(list));

    }
}
