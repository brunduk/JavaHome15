import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow", "Ufa", 7000, 10_20, 14_20);
    Ticket ticket2 = new Ticket("Minsk", "Moscow", 6500, 15_10, 17_10);
    Ticket ticket3 = new Ticket("Saint_Petersburg", "Moscow", 2500, 8_30, 9_30);
    Ticket ticket4 = new Ticket("Helsinki", "Saint_Petersburg", 3000, 10_50, 13_50);
    Ticket ticket5 = new Ticket("Moscow", "Ufa", 5000, 15_20, 20_20);
    private Comparator<Ticket> TicketTimeComparator;

    @Test
    public void compare() {
        Ticket[] ticket = new Ticket[]{
                ticket1, ticket2, ticket3, ticket4, ticket5
        };

        Arrays.sort(ticket);

        Ticket[] expected = {ticket3, ticket4, ticket5, ticket2, ticket1};

        Assertions.assertArrayEquals(expected, ticket);
    }


    @Test
    public void searchSortPriceTwoTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {ticket5, ticket1};

        Assertions.assertArrayEquals(expected, ss.search("Moscow", "Ufa"));
    }

    @Test
    public void searchSortPriceOneTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, ss.search("Minsk", "Moscow"));
    }

    @Test
    public void searchSortPriceNullTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, ss.search("Novosibirsk", "Dubai"));
    }

    @Test
    public void comparator() {
        TicketTimeComparator tt = new TicketTimeComparator();

        Ticket[] ticket = new Ticket[]{
                ticket1, ticket2, ticket3, ticket4, ticket5
        };
        Arrays.sort(ticket, tt);

        Ticket[] expected = {ticket3, ticket2, ticket4, ticket1, ticket5};

        Assertions.assertArrayEquals(expected, ticket);
    }

    @Test
    public void searchComparatorTwoTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {ticket5, ticket1};

        Assertions.assertArrayEquals(expected, ss.searchAndSortBy("Moscow", "Ufa", TicketTimeComparator));
    }

    @Test
    public void searchComparatorOneTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, ss.searchAndSortBy("Minsk", "Moscow", TicketTimeComparator));
    }

    @Test
    public void searchComparatorNullTicket() {
        AviaSouls ss = new AviaSouls();
        ss.add(ticket1);
        ss.add(ticket2);
        ss.add(ticket3);
        ss.add(ticket4);
        ss.add(ticket5);

        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, ss.searchAndSortBy("Novosibirsk", "Dubai", TicketTimeComparator));
    }
}
