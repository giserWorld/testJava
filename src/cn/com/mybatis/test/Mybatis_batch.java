package cn.com.mybatis.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.mybatis.dataSouce.DataConnecton;
import cn.com.mybatis.mapper.CustomerMapper;
import cn.com.mybatis.po.BatchCustomer;
import cn.com.mybatis.po.BatchItem;
import cn.com.mybatis.po.BatchItem_multi;
import cn.com.mybatis.po.Batch_extend;
import cn.com.mybatis.po.Batchdetail;
import cn.com.mybatis.po.Batchdetail_extend;
import cn.com.mybatis.po.Customer;
import cn.com.mybatis.po.Customer_extend;
import cn.com.mybatis.po.FinacialProducts;

public class Mybatis_batch {
	DataConnecton dataConn=new DataConnecton();
	
	//二级缓存(mapper缓存)
	@Test
	public void testFindCustomerMapper2() throws Exception{
		SqlSession sqlSession=dataConn.getSqlSession();
		//第一次查询customer信息
		CustomerMapper customerMapper=sqlSession.getMapper(CustomerMapper.class);
		Customer user=customerMapper.findCustomerById(1);
		System.out.println("用户名:"+user.getUsername()+" | 卡号:"+user.getAcno());
		
		//修改customer信息
		CustomerMapper customerMapper2=sqlSession.getMapper(CustomerMapper.class);
		user.setAcno("66666666666666");
		customerMapper2.updateCustomer(user);
		System.out.println("修改用户名:"+user.getUsername()+" | 卡号:"+user.getAcno());
		sqlSession.commit();//提交到数据库，清空缓存
		
		//第二次查询customer信息
		CustomerMapper customerMapper3=sqlSession.getMapper(CustomerMapper.class);
		Customer user2=customerMapper3.findCustomerById(1);
		System.out.println("用户名:"+user2.getUsername()+" | 卡号:"+user2.getAcno());
		sqlSession.close();
	}
	
	//一级缓存(sqlSession缓存)
	@Test
	public void testFindCustomerCache1() throws Exception{
		SqlSession sqlSession=dataConn.getSqlSession();
		//第一次查询customer信息
		Customer user=sqlSession.selectOne("cn.com.mybatis.mapper.CustomerMapper.findCustomerById",1);
		System.out.println("用户名:"+user.getUsername()+" | 卡号:"+user.getAcno());
		
		//第二次查询customer信息
		Customer user2=sqlSession.selectOne("cn.com.mybatis.mapper.CustomerMapper.findCustomerById",1);
		System.out.println("用户名:"+user2.getUsername()+" | 卡号:"+user2.getAcno());
		sqlSession.close();
	}
	
	//一对一信息查询(resultType)
	@Test
	public void batch_customter() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		List<BatchCustomer> batch_infos=sqlSession.selectList("test_batch.findBatchCustomter");
		
		SimpleDateFormat time_format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//遍历list信息数组
		for(int i=0;i<batch_infos.size();i++){
			BatchCustomer oneInfo=batch_infos.get(i);
			String cardNum=oneInfo.getAcno();//卡号
			String name=oneInfo.getUsername();//用户名
			String number=oneInfo.getNumber();//批次号
			String time=time_format.format(oneInfo.getCreatetime());
			System.out.println("卡号为"+cardNum+"名为"+name+"的客户："+"于"+time+"采购了批次号为"+number+"的一批理财产品");
		}
		sqlSession.close();
	}

	
		//一对一信息查询(resultMap,association)
		@Test
		public void batch_customter_map() throws IOException{
			SqlSession sqlSession=dataConn.getSqlSession();
			List<BatchItem> batchItems=sqlSession.selectList("test_batch.findBatchCustomerToMap");
			
			SimpleDateFormat time_format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			BatchItem batchItem=null;
			Customer customer=null;
			
			//遍历list信息数组
			for(int i=0;i<batchItems.size();i++){
				batchItem=batchItems.get(i);
				customer=batchItem.getCustomer();//用户
				
				String name=customer.getUsername();//用户名
				String cardNum=customer.getAcno();//卡号
				String number=batchItem.getNumber();//批次号
				String time=time_format.format(batchItem.getCreatetime());//时间
				System.out.println("卡号为"+cardNum+"名为"+name+"的客户："+"于"+time+"采购了批次号为"+number+"的一批理财产品");
			}
			sqlSession.close();
		}
		
		//一对多信息查询(resultMap,collection)
		@Test
		public void batch_batchDetail_map() throws IOException{
			SqlSession sqlSession=dataConn.getSqlSession();
			List<BatchItem_multi> batchItem_multis=sqlSession.selectList("test_batch.findBatchAndBatchDetail");
			BatchItem_multi batchItem_multi=batchItem_multis.get(0);
			SimpleDateFormat time_format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Customer customer=batchItem_multi.getCustomer();//用户
			List<Batchdetail> batch_details=batchItem_multi.getBatchdetail_list();//批次包含的理财产品
			String name=customer.getUsername();//用户名
			String cardNum=customer.getAcno();//卡号
			String number=batchItem_multi.getNumber();//批次号
			String time=time_format.format(batchItem_multi.getCreatetime());//时间
			System.out.println("卡号为"+cardNum+"名为"+name+"的客户："+"于"+time+"采购了批次号为"+number+"的一批理财产品，详情如下：");
			
			//遍历list信息数组
			for(int i=0;i<batch_details.size();i++){
				Batchdetail batch_detail=batch_details.get(i);//获取批次中单个理财产品
				int product_id=batch_detail.getProduct_id();//理财产品Id
				int product_num=batch_detail.getProduct_num();//理财产品数量
				System.out.println("id为"+product_id+"的理财产品"+product_num+"份");
			}
			sqlSession.close();
		}
		
		
		//多对多信息查询(resultMap)
		@Test
		public void testFindUserAndProduct() throws IOException{
			SqlSession sqlSession=dataConn.getSqlSession();
			List<Customer_extend> customers=sqlSession.selectList("test_batch.findUserAndProduct");
			SimpleDateFormat time_format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//for循环结果数据
			for(int i=0;i<customers.size();i++){
				Customer_extend user=customers.get(i);//客户
				//1.获取用户基本信息
				String name=user.getUsername();//用户名
				String cardNum=user.getAcno();//卡号
				System.out.println("卡号为"+cardNum+"名为"+name+"的客户：");
				//2.获取用户下所有的批次订单信息
				List<Batch_extend> batchList=user.getBatchList();//批次列表
				for(int j=0;j<batchList.size();j++){
					Batch_extend batch=batchList.get(j);
					String number=batch.getNumber();//批次号
					String date=time_format.format(batch.getCreatetime());//时间
					System.out.println("于"+date+"采购了批次号为"+number+"的一批理财产品，详情如下：");
					//3.获取一个批次的明细
					 List<Batchdetail_extend> batchdetailList=batch.getBatchdetailList();
					 for(int k=0;k<batchdetailList.size();k++){
						 Batchdetail_extend  batchdetail=batchdetailList.get(i);
						 int product_id=batchdetail.getProduct_id();//理财产品Id
						 int product_num=batchdetail.getProduct_num();//理财产品数量
						 System.out.println("id为"+product_id+"的理财产品"+product_num+"份");
						 
						//3.获取一个批次的明细中理财产品的详细信息
						 FinacialProducts finacialProducts=batchdetail.getFinacialProducts();
						 String name2=finacialProducts.getName();//理财产品名称
						 double price=finacialProducts.getPrice();//理财产品价格
						 String text=finacialProducts.getDetail();//理财产品简介
						 System.out.println("该理财产品的详细信息为:\n"
							 +"产品名称： "+name2
							 +" | 理财产品价格: "+price
							 +" | 理财产品简介: "+text
						 );
					 }
					 System.out.println("****************************************");
				}
			}
			sqlSession.close();
		}
		
		//延迟加载
		@Test
		public void testFindBatchCustomerLazyLoading() throws IOException{
			SqlSession sqlSession=dataConn.getSqlSession();
			List<BatchItem> batchItem2=sqlSession.selectList("test_batch.findBatchUserLazyLoading");
			
			//for循环结果数据
			for(int i=0;i<batchItem2.size();i++){
				BatchItem batch2=batchItem2.get(i);//客户
				String number=batch2.getNumber();//批次号
				System.out.println("订单编号："+number);
				//Customer user=batch2.getCustomer();//客户
				//String name2=user.getUsername();//用户名
				
				//System.out.println("订购用户名："+name2);
			}
			sqlSession.close();
		}
		
		
		//mapper代理接口
		@Test
		public void testFindCustomerOnMapper() throws Exception{
			SqlSession sqlSession=dataConn.getSqlSession();
			//获取mapper代理接口
			CustomerMapper customerMapper=sqlSession.getMapper(CustomerMapper.class);
			//执行Mapper代理对象的查询方法
			Customer user=customerMapper.findCustomerById(1);
			System.out.println("用户名:"+user.getUsername()+" | 卡号:"+user.getAcno());
			sqlSession.close();
		}
		
}
