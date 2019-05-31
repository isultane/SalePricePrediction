/**
*  Created by Sultan S. Alqahtani on 2019-05-25.
**/
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


public class Regression {
	public static void main(String[] args) throws Exception{
		DataSource source = new DataSource("house.arff");
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		/**
		 * linear regression model
		 */
		LinearRegression lr_model = new LinearRegression();
		lr_model.buildClassifier(dataset);
//		System.out.println("LR formula: " + lr_model);
		//System.out.println(lr);
/*		Evaluation lreval = new Evaluation(dataset);
		lreval.evaluateModel(lr, dataset);
		System.out.println(lreval.toSummaryString()); */

		/**
		 * svm regression model
		 */
		SMOreg svm_model = new SMOreg();
		svm_model.buildClassifier(dataset);
//		System.out.println("SVM formula: " + svm_model);
/*		Evaluation svmregeval = new Evaluation(dataset);
		svmregeval.evaluateModel(smoreg, dataset);
		System.out.println(svmregeval.toSummaryString()); */
		
		
		// Predict the price 
		Instance myHouse = dataset.lastInstance();
		System.out.println("House information: " + myHouse);
		double lr_price = lr_model.classifyInstance(myHouse);
		double svm_price = svm_model.classifyInstance(myHouse);
		System.out.println("-------------------------");
		System.out.println("Price prediction using LR:  " + lr_price);
		System.out.println("Price prediction using SVM: " + svm_price);
		

	}
}