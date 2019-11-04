package com.v.viagogo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-19 18:48
 */
public class ListingApp {

    public interface Supply {

            Event getEvent();

            int getTicketQuantity();

            int getTicketPrice();

            int getId();

            String getSupplier();

    }

    public class SupplyImpl implements Supply{

        Object supplier;

        public SupplyImpl (Object api) {
            this.supplier = api;
        }

        @Override
        public Event getEvent() {
            return null;
        }

        @Override
        public int getTicketQuantity() {
            return 0;
        }

        @Override
        public int getTicketPrice() {
            return 0;
        }

        @Override
        public int getId() {
            return 0;
        }

        @Override
        public String getSupplier() {
            return null;
        }
    }

    public static void main(String[] args) throws java.lang.Exception{
        ViagogoApi viagogo = new ViagogoApi();
        SupplierAApi supplierA = new SupplierAApi();
        SupplierBApi supplierB = new SupplierBApi();

        List<Event> events = viagogo.getEvents();
        List<Listing> listings = new ArrayList<Listing>();

        for (Event event:events) {
            int eventId = supplierA.getEventId(event.getName());
            List<SupplierAListing> aListings = supplierA.getAvailableListings(eventId);
            for (SupplierAListing l : aListings) {
                listings.add(new Listing(event, l.getTicketQuantity(), l.getTicketPrice(), l.getId(), "Supplier A"));
            }
            List<SupplierBListing> bListings = supplierB.getListings(event.getName());
            for (SupplierBListing l : bListings){
                double price = l.getTotalPrice() / l.getAvailableTickets();
                listings.add(new Listing(event, l.getAvailableTickets(), price, l.getListingId(), "Supplier B"));
            }
        }

        viagogo.CreateListings(listings);
    }

}

class Event{

    String name;

    String getName(){
        return name;
    }
}

class Listing{

    public Listing(Event event, int quantity, double price, int id, String name){

    }

}

class ViagogoApi {

    List<Event> getEvents(){
        return new ArrayList<>();
    }

    void CreateListings(List<Listing> listings){

    }
}

class SupplierAApi{

    int getEventId (String name) {
        return 0;
    }

    List<SupplierAListing> getAvailableListings(int eventId) {
        return new ArrayList<SupplierAListing>();
    }
}

class SupplierAListing{

    int id;
    double price;
    int quantity;

    int getTicketQuantity(){
        return quantity;
    }

    double getTicketPrice(){
        return price;
    }

    int getId(){
        return id;
    }
}

class SupplierBApi{

    List<SupplierBListing> getListings(String name) {
        return new ArrayList<SupplierBListing>();
    }
}

class SupplierBListing{

    int getTotalPrice(){
        return 0;
    }

    int getAvailableTickets(){
        return 0;
    }

    int getListingId(){
        return 0;
    }
}