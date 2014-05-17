package in.mused.api.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionTracker implements HttpSessionListener {
 
 
  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
	//Thread.dumpStack();
  }

@Override
public void sessionDestroyed(HttpSessionEvent se) {
	// TODO Auto-generated method stub
	
}
	
}