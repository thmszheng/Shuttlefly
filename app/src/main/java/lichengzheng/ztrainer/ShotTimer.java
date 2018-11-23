package lichengzheng.ztrainer;
import java.util.*;


public class ShotTimer
{
	private int gameSpeed;
	private Map<String, Integer> shotSpeedMap;
	
	
	public ShotTimer(int gameSpeed) //constructor
	{
		this.gameSpeed = gameSpeed+2;
		shotSpeedMap = new HashMap<String, Integer>();
		shotSpeedMap.put("defensiveClear", 15000);
		shotSpeedMap.put("defensiveLift", 15000);
		shotSpeedMap.put("slowDrop", 10000);
		shotSpeedMap.put("fastDrop", 7000);
		shotSpeedMap.put("offensiveClear", 12000);
		shotSpeedMap.put("offensiveLift", 13000);
		shotSpeedMap.put("net", 8000);
		shotSpeedMap.put("block", 10000);
		shotSpeedMap.put("drive", 3500);
		shotSpeedMap.put("halfSmash", 4000);
		shotSpeedMap.put("powerSmash", 3000);
		shotSpeedMap.put("netKill", 2000);
	}
	
	public int getShotTime(String trainerShot,String traineeShot)
	{
		int trainerShotSpeed = shotSpeedMap.get(trainerShot);
		int traineeShotSpeed =  shotSpeedMap.get(traineeShot);
        int waitTime = (trainerShotSpeed/gameSpeed) + (traineeShotSpeed/gameSpeed);
		return waitTime/100;
	}

}
