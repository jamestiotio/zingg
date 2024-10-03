package zingg.spark.core.executor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;

import zingg.common.client.IArguments;
import zingg.common.client.ZinggClientException;
import zingg.common.core.executor.TrainMatchTester;
import zingg.common.core.executor.TrainMatcher;

public class SparkTrainMatchTester extends TrainMatchTester<SparkSession,Dataset<Row>,Row,Column,DataType> {
    
    public static final Log LOG = LogFactory.getLog(SparkTrainMatchTester.class);

	public SparkTrainMatchTester(TrainMatcher<SparkSession,Dataset<Row>,Row,Column,DataType> executor,IArguments args) {
		super(executor,args);
	}

    @Override
	public void validateResults() throws ZinggClientException {
		// check that model is created
		LOG.info("Zingg Model Dir : "+args.getZinggModelDir());
		
		File modelDir = new File(args.getZinggModelDir());
		assertTrue(modelDir.exists(),"check if model has been created");
	}

}
