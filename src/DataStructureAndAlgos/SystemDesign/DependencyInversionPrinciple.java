package DataStructureAndAlgos.SystemDesign;

/*Using a tightly coupled code and not using DIP*/

class RecentlyAdded
{
   public void getRecommedationsVal()
   {
      System.out.println("Showing Recently added content");
   }
}

class RecommendationEngine
{
   private RecentlyAdded recommender = new RecentlyAdded();
   {
      recommender.getRecommedationsVal();
   }
}

/*
 * Using a good abstraction/interface model, we can create a better way to fetch the recommendation Since they are loosely coupled and follow DIP<we dont need
 * to change the base code>, we can create modules that help in this without loosing essence of the code / future modifications.
 */

interface recommendationStrategy
{
   void getRecommendations();
}

class recentlyAdd implements recommendationStrategy
{
   public void getRecommendations()
   {
      System.out.println("Showing recently added content based on preferences");
   }
}

class TrendingNow implements recommendationStrategy
{
   public void getRecommendations()
   {
      System.out.println("Showing the trending now recommendations");
   }
}

class GenreBased implements recommendationStrategy
{
   public void getRecommendations()
   {
      System.out.println("Showing content based on your favorite genres...");
   }
}

class RecommendationEnginePoint
{
   private recommendationStrategy strategy;

   public RecommendationEnginePoint(recommendationStrategy strategy)
   {
      this.strategy = strategy;
   }

   public void recommend()
   {
      strategy.getRecommendations();
   }
}

public class DependencyInversionPrinciple
{
   public static void main(String[] args)
   {
      RecommendationEnginePoint engine = new RecommendationEnginePoint(new GenreBased());
      RecommendationEnginePoint engineTwo = new RecommendationEnginePoint(new TrendingNow());
      RecentlyAdded engOne = new RecentlyAdded();
      engOne.getRecommedationsVal();
      engine.recommend();
      engineTwo.recommend();
   }
}
