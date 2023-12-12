package zingg.spark.core.documenter;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.DataType;

import freemarker.template.Version;
import zingg.common.client.IArguments;
import zingg.common.core.Context;
import zingg.common.core.documenter.DataColDocumenter;
import zingg.common.core.documenter.RowWrapper;
import zingg.spark.client.ZSparkSession;

/**
 * Spark specific implementation of DataColDocumenter
 *
 */
public class SparkDataColDocumenter extends DataColDocumenter<ZSparkSession, Dataset<Row>, Row, Column,DataType> {

	private static final long serialVersionUID = 1L;

	public SparkDataColDocumenter(Context<ZSparkSession, Dataset<Row>, Row, Column,DataType> context, IArguments args) {
		super(context, args);
	}

	@Override
	public RowWrapper<Row> getRowWrapper(Version v) {
		return new SparkRowWrapper(v);
	}

}
