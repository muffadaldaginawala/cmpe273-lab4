package edu.sjsu.cmpe.cache.client;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Cache Service Starting... ");
        CacheServiceInterface cache = new DistributedCacheService(
                "http://localhost:3000");
        CacheServiceInterface myCache = new DistributedCacheService(
                "http://localhost:3000","http://localhost:3001","http://localhost:3002");


        System.out.println("putting (1 => a)");
        myCache.asyncPUT(1, "a");
        System.out.println("Sleeping for 30 seconds...");
        Thread.sleep(30000);
        System.out.println("Updating putting (1 => b)");
        myCache.asyncPUT(1, "b");
        System.out.println("Sleeping for 30 seconds...");
        Thread.sleep(30000);
        System.out.println("getting values...");
        String value = myCache.asyncGET(1);
        System.out.println("Value received: "+value);
        System.out.println("Existing Cache Client...");
    }

}
