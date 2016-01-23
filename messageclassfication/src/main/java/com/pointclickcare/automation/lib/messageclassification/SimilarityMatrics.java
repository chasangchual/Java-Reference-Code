package com.pointclickcare.automation.lib.messageclassification;

public class SimilarityMatrics {
	public static float findCosineSimilarity(float[] vecA, float[] vecB) {
		float dotProduct = dotProduct(vecA, vecB);
		float magnitudeOfA = magnitude(vecA);
		float magnitudeOfB = magnitude(vecB);
		
		if(magnitudeOfA == 0 || magnitudeOfB == 0) {
			return 0 ;
		}
		
		float result = dotProduct / (magnitudeOfA * magnitudeOfB);
		return result;		
	}
	
	public static float dotProduct(float[] vecA, float[] vecB) {
		float dotProduct = 0.0f ;
		
		for(int i = 0; i < vecA.length; i++) {
			dotProduct += vecA[i] * vecB[i] ;
		}
		return dotProduct ;
	}
	
	// Magnitude of the vector is the square root of the dot product of the vector with itself.
	public static float magnitude(float[] vec) {
		return (float)Math.sqrt(dotProduct(vec, vec)) ;
	}
	
	//Computes the similarity between two documents as the distance between their point representations. Is translation invariant.
	public static float findEuclideanDistance(int[] vecA, int[] vecB) {
		float euclideanDistance = 0 ; 
		for(int i = 0 ; i < vecA.length; i++) {
			euclideanDistance += (float) Math.pow((double)(vecA[i] - vecB[i]), (double)2) ;
		}
		
		return (float)Math.sqrt(euclideanDistance) ;
	}
	
	//Combines properties of both cosine similarity and Euclidean distance
	public static float findExtendedJaccard(float[] vecA, float[] vecB) {
		float dotProduct = dotProduct(vecA, vecB) ;
		float magnitudeA = magnitude(vecA) ;
		float magnitudeB = magnitude(vecB) ;
		
		return dotProduct / (magnitudeA + magnitudeB - dotProduct) ;
	}
}
