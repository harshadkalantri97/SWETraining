package DataStructureAndAlgos.SystemDesign;

public interface InterfaceSegregrationPrinciple
{
   // BAD Inteface - not recommended using ISP in System Design Learning 01
   interface UberUser
   {
      void BookRide();

      void acceptride();

      void trackEarning();

      void ratePassengers();

      void rateDriver();
   }

   class Rider implements UberUser
   {
      public void bookRide()
      { /* yes */ }

      public void acceptRide()
      { /* not needed */ }

      public void trackEarnings()
      { /* not needed */ }

      public void ratePassenger()
      { /* not needed */ }

      public void rateDriver()
      { /* yes */ }

      @Override
      public void BookRide()
      {
         // TODO Auto-generated method stub

      }

      @Override
      public void acceptride()
      {
         // TODO Auto-generated method stub

      }

      @Override
      public void trackEarning()
      {
         // TODO Auto-generated method stub

      }

      @Override
      public void ratePassengers()
      {
         // TODO Auto-generated method stub

      }
   }

   /*
    * To use a good interface, we should ensure that the interface is small, compact and anyone can understand as a developer. As per ISP rules, we should avoid
    * bloating any interface and not let anything bigger and sophisticated. Above shows how its causing issues of all when not needed.
    */

   /* For a good System design of ISP - Let's see the above */

   interface RiderInterface
   {
      void bookRide();

      void rateDriver();
   }

   interface DriverInterface
   {
      void acceptRide();

      void trackEarnings();

      void ratePassenger();
   }

   class NewRider implements RiderInterface
   {
      public void bookRide()
      { /* yes */ }

      public void rateDriver()
      { /* yes */ }
   }

   class Driver implements DriverInterface
   {
      public void acceptRide()
      { /* yes */ }

      public void trackEarnings()
      { /* yes */ }

      public void ratePassenger()
      { /* yes */ }
   }

   /*
    * Now, each class has exactly what it needs - no more, no less.
    * Thus, following the ISP keeps the code clean and easy to maintain.
    */
}
