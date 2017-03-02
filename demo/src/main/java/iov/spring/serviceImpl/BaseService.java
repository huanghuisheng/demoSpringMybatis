package iov.spring.serviceImpl;

import iov.spring.dao.DeviceMapper;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("basicService")
public class BaseService {
	@Autowired
	protected DeviceMapper deviceMapper;

}
