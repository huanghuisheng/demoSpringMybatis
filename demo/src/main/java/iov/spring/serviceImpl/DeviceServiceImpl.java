package iov.spring.serviceImpl;

import iov.spring.entity.Device;
import iov.spring.service.DeviceService;

import org.springframework.stereotype.Service;

@Service("deviceService")
public class DeviceServiceImpl extends BaseService implements DeviceService {
//  private	DeviceMapper deviceMapper =null;
//
//	public DeviceServiceImpl() {
//
//		// 创建代理对象
//		if(deviceMapper==null){
//			System.out.println("----------1---------"+sqlSession);
//			deviceMapper = sqlSession.getMapper(DeviceMapper.class);	
//		}
//		
//
//	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int insert(Device record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Device record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Device selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("-------------");
		Device device=	deviceMapper.selectByPrimaryKey(1);
		System.out.println("------"+device.getImei());
		
		return device;
	}

	@Override
	public int updateByPrimaryKeySelective(Device record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Device record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
