import java.util.Comparator;

class SortByTime implements Comparator<turn>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(turn a, turn b)
    {
        return a.time - b.time;
    }
}