package lichengzheng.ztrainer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ShotSelector
{
	private Map<String, Set<String>> returnShotMap;
	private Map<String, Integer> returnShotRowMap,drawableShotMap;
	private Set<String> netReturnShots,netKillReturnShots,clearReturnShots,
			            slowDropReturnShots,fastDropReturnShots,offensiveLiftReturnShots,
					    blockReturnShots,driveReturnShots,halfSmashReturnShots,powerSmashReturnShots;
	
	private Set<String> eLevelShots,dLevelShots,cLevelShots,bLevelShots,aLevelShots,trainerSixCornerShots,traineeSixCornerShots,
                        trainerFourCornerShot,traineeFourCornerShot,trainerTwoCornerShot,traineeTwoCornerShot,trainerNetShot,
                        traineeNetShot,trainerDropShot,traineeDropShot,trainerSmashShot,traineeSmashShot,trainerClearShot,traineeClearShot;
	
	private Random randomNumberGenerator;
	private int playerLevel,trainingMode;
	
	public ShotSelector(int playerLevel,int trainingMode) //constructor
	{
		
		netReturnShots           = new HashSet<String>();
		netKillReturnShots       = new HashSet<String>();
		clearReturnShots         = new HashSet<String>();
		slowDropReturnShots      = new HashSet<String>();
		fastDropReturnShots      = new HashSet<String>();
		offensiveLiftReturnShots = new HashSet<String>();
		blockReturnShots         = new HashSet<String>();
		driveReturnShots         = new HashSet<String>();
		halfSmashReturnShots     = new HashSet<String>();
		powerSmashReturnShots    = new HashSet<String>();
		
		netReturnShots.addAll(Arrays.asList(new String[]{"net","netKill","defensiveLift","offensiveLift"}));
		netKillReturnShots.addAll(Arrays.asList(new String[]{"block","defensiveLift"}));
		offensiveLiftReturnShots.addAll(Arrays.asList(new String[]{"slowDrop","fastDrop","defensiveClear","drive"}));
		clearReturnShots.addAll(Arrays.asList(new String[]{"halfSmash","powerSmash","defensiveClear","offensiveClear","slowDrop","fastDrop"}));
		slowDropReturnShots.addAll(Arrays.asList(new String[]{"net","defensiveLift","offensiveLift"}));
		fastDropReturnShots.addAll(Arrays.asList(new String[]{"block","defensiveLift","offensiveLift"}));
		blockReturnShots.addAll(Arrays.asList(new String[]{"net","defensiveLift"}));
		driveReturnShots.addAll(Arrays.asList(new String[]{"block","defensiveLift","drive"}));
		halfSmashReturnShots.addAll(Arrays.asList(new String[]{"block","defensiveLift"}));
		powerSmashReturnShots.addAll(Arrays.asList(new String[]{"block"}));

		returnShotMap = new HashMap<String, Set<String>>();
		returnShotMap.put("net", netReturnShots);
		returnShotMap.put("netKill", netKillReturnShots);
		returnShotMap.put("defensiveClear", clearReturnShots);
		returnShotMap.put("defensiveLift", clearReturnShots);
		returnShotMap.put("offensiveClear", offensiveLiftReturnShots);
		returnShotMap.put("offensiveLift", offensiveLiftReturnShots);
		returnShotMap.put("slowDrop", slowDropReturnShots);
		returnShotMap.put("fastDrop", fastDropReturnShots);
		returnShotMap.put("block", blockReturnShots);
		returnShotMap.put("drive", driveReturnShots);
		returnShotMap.put("halfSmash", halfSmashReturnShots);
		returnShotMap.put("powerSmash", powerSmashReturnShots);

		returnShotRowMap = new HashMap<String, Integer>();
		returnShotRowMap.put("Trainer_net",4);
		returnShotRowMap.put("Trainee_net",3);
		returnShotRowMap.put("Trainer_netKill",5);
		returnShotRowMap.put("Trainee_netKill",2);
		returnShotRowMap.put("Trainer_defensiveClear",7);
		returnShotRowMap.put("Trainee_defensiveClear",0);
		returnShotRowMap.put("Trainer_defensiveLift",7);
		returnShotRowMap.put("Trainee_defensiveLift",0);
		returnShotRowMap.put("Trainer_offensiveClear",7);
		returnShotRowMap.put("Trainee_offensiveClear",0);
		returnShotRowMap.put("Trainer_offensiveLift",7);
		returnShotRowMap.put("Trainee_offensiveLift",0);
		returnShotRowMap.put("Trainer_slowDrop",4);
		returnShotRowMap.put("Trainee_slowDrop",3);
		returnShotRowMap.put("Trainer_fastDrop",5);
		returnShotRowMap.put("Trainee_fastDrop",2);
		returnShotRowMap.put("Trainer_block",4);
		returnShotRowMap.put("Trainee_block",3);
		returnShotRowMap.put("Trainer_drive",6);
		returnShotRowMap.put("Trainee_drive",1);
		returnShotRowMap.put("Trainer_halfSmash",6);
		returnShotRowMap.put("Trainee_halfSmash",1);
		returnShotRowMap.put("Trainer_powerSmash",6);
		returnShotRowMap.put("Trainee_powerSmash",1);

		drawableShotMap = new HashMap<String,Integer>();
		drawableShotMap.put("Trainer_net",R.drawable.trainer_net);
		drawableShotMap.put("Trainee_net",R.drawable.trainee_net);
		drawableShotMap.put("Trainer_netKill",R.drawable.trainer_net_kill);
		drawableShotMap.put("Trainee_netKill",R.drawable.trainee_net_kill);
		drawableShotMap.put("Trainer_defensiveClear",R.drawable.trainer_clear);
		drawableShotMap.put("Trainee_defensiveClear",R.drawable.trainee_clear);
		drawableShotMap.put("Trainer_defensiveLift",R.drawable.trainer_lift);
		drawableShotMap.put("Trainee_defensiveLift",R.drawable.trainee_lift);
		drawableShotMap.put("Trainer_offensiveClear",R.drawable.trainer_fast_clear);
		drawableShotMap.put("Trainee_offensiveClear",R.drawable.trainee_fast_clear);
		drawableShotMap.put("Trainer_offensiveLift",R.drawable.trainer_fast_lift);
		drawableShotMap.put("Trainee_offensiveLift",R.drawable.trainee_fast_lift);
		drawableShotMap.put("Trainer_slowDrop",R.drawable.trainer_drop);
		drawableShotMap.put("Trainee_slowDrop",R.drawable.trainee_drop);
		drawableShotMap.put("Trainer_fastDrop",R.drawable.trainer_fast_drop);
		drawableShotMap.put("Trainee_fastDrop",R.drawable.trainee_fast_drop);
		drawableShotMap.put("Trainer_block",R.drawable.trainer_block);
		drawableShotMap.put("Trainee_block",R.drawable.trainee_block);
		drawableShotMap.put("Trainer_drive",R.drawable.trainer_drive);
		drawableShotMap.put("Trainee_drive",R.drawable.trainee_drive);
		drawableShotMap.put("Trainer_halfSmash",R.drawable.trainer_smash);
		drawableShotMap.put("Trainee_halfSmash",R.drawable.trainee_smash);
		drawableShotMap.put("Trainer_powerSmash",R.drawable.trainer_jump_smash);
		drawableShotMap.put("Trainee_powerSmash",R.drawable.trainee_jump_smash);


		aLevelShots = new HashSet<String>();
		aLevelShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","powerSmash","block",
				                                      "offensiveLift","offensiveClear","drive","netKill","fastDrop"}));

		bLevelShots = new HashSet<String>();
		bLevelShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","powerSmash","block",
		                                              "offensiveLift","offensiveClear","drive","fastDrop"}));

		cLevelShots = new HashSet<String>();
		cLevelShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","powerSmash","block",
		                                              "drive","offensiveLift"}));

		dLevelShots = new HashSet<String>();
		dLevelShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","block","powerSmash"}));

		eLevelShots  = new HashSet<String>();
		eLevelShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","block"}));



		trainerSixCornerShots = new HashSet<String>();
		trainerSixCornerShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","block",
                                                                "powerSmash","offensiveClear","offensiveLift","drive"}));
		traineeSixCornerShots = new HashSet<String>();
		traineeSixCornerShots.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift","halfSmash","block",
                                                                "powerSmash","offensiveClear","offensiveLift","drive"}));
		trainerFourCornerShot = new HashSet<String>();
        trainerFourCornerShot.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift",
                                                                "offensiveClear","offensiveLift"}));
        traineeFourCornerShot = new HashSet<String>();
        traineeFourCornerShot.addAll(Arrays.asList(new String[]{"defensiveClear","slowDrop","net","defensiveLift",
                                                                "offensiveClear","offensiveLift"}));
        trainerTwoCornerShot = new HashSet<String>();
        trainerTwoCornerShot.addAll(Arrays.asList(new String[]{"slowDrop","net"}));
        traineeTwoCornerShot = new HashSet<String>();
        traineeTwoCornerShot.addAll(Arrays.asList(new String[]{"defensiveLift","offensiveLift","net"}));

        trainerNetShot = new HashSet<String>();
        trainerNetShot.addAll(Arrays.asList(new String[]{"netKill","net","block"}));
        traineeNetShot = new HashSet<String>();
        traineeNetShot.addAll(Arrays.asList(new String[]{"netKill","net","block"}));

        trainerDropShot = new HashSet<String>();
        trainerDropShot.addAll(Arrays.asList(new String[]{"slowDrop","fastDrop","net"}));
        traineeDropShot = new HashSet<String>();
        traineeDropShot.addAll(Arrays.asList(new String[]{"defensiveLift","offensiveLift","block"}));

        trainerSmashShot = new HashSet<String>();
        trainerSmashShot.addAll(Arrays.asList(new String[]{"halfSmash","powerSmash","net"}));
        traineeSmashShot = new HashSet<String>();
        traineeSmashShot.addAll(Arrays.asList(new String[]{"defensiveLift","block"}));

        trainerClearShot = new HashSet<String>();
        trainerClearShot.addAll(Arrays.asList(new String[]{"defensiveClear","offensiveClear","defensiveLift","offensiveLift","block"}));
        traineeClearShot = new HashSet<String>();
        traineeClearShot.addAll(Arrays.asList(new String[]{"defensiveClear","offensiveClear","slowDrop","fastDrop","halfSmash","powerSmash",
                                                           "drive","net"}));




		randomNumberGenerator = new Random();
		
		this.playerLevel = playerLevel;
		this.trainingMode = trainingMode;
	}
	
	//methods
	private Set<String> generateReturnShotsByLevel(String arrivalShot)
	{
		Set<String> possibleReturnShots = new HashSet<String>();
		for(String value : returnShotMap.get(arrivalShot))
		{
			possibleReturnShots.add(value);
		}
		switch(playerLevel)
		{
			case 1:
				possibleReturnShots.retainAll(eLevelShots);
				break;
			case 2:
				possibleReturnShots.retainAll(dLevelShots);
				break;
			case 3:
				possibleReturnShots.retainAll(cLevelShots);
				break;
			case 4:
				possibleReturnShots.retainAll(bLevelShots);
				break;
			case 5:
				possibleReturnShots.retainAll(aLevelShots);
				break;
		}
		return possibleReturnShots;

	}

	public String generateTrainerReturnShot(String arrivalShot)
    {
        Set<String> possibleReturnShots = generateReturnShotsByLevel(arrivalShot);
        switch(trainingMode)
        {
            case 1:
                break;
            case 2:
                possibleReturnShots.retainAll(trainerSixCornerShots);
                break;
            case 3:
                possibleReturnShots.retainAll(trainerFourCornerShot);
                break;
            case 4:
                possibleReturnShots.retainAll(trainerTwoCornerShot);
                break;
            case 5:
                possibleReturnShots.retainAll(trainerNetShot);
                break;
            case 6:
                possibleReturnShots.retainAll(trainerDropShot);
                break;
            case 7:
                possibleReturnShots.retainAll(trainerSmashShot);
                break;
            case 8:
                possibleReturnShots.retainAll(trainerClearShot);
                break;
        }
        return chooseRandomShot(possibleReturnShots);
    }

    public String generateTraineeReturnShot(String arrivalShot)
    {
        Set<String> possibleReturnShots = generateReturnShotsByLevel(arrivalShot);
        switch(trainingMode)
        {
            case 1:
                break;
            case 2:
                possibleReturnShots.retainAll(traineeSixCornerShots);
                break;
            case 3:
                possibleReturnShots.retainAll(traineeFourCornerShot);
                break;
            case 4:
                possibleReturnShots.retainAll(traineeTwoCornerShot);
                break;
            case 5:
                possibleReturnShots.retainAll(traineeNetShot);
                break;
            case 6:
                possibleReturnShots.retainAll(traineeDropShot);
                break;
            case 7:
                possibleReturnShots.retainAll(traineeSmashShot);
                break;
            case 8:
                possibleReturnShots.retainAll(traineeClearShot);
                break;
        }
        return chooseRandomShot(possibleReturnShots);
    }



	public int generateReturnShotColumn()
	{
        switch(trainingMode)
        {
            case 1:
            case 5:
            case 6:
            case 7:
            case 8:
                return randomNumberGenerator.nextInt(3);
            default:
                return ((randomNumberGenerator.nextInt() % 2 == 0) ? 0 : 2);
        }
	}
	public int generateReturnShotRow(String shotType)
	{
		return returnShotRowMap.get(shotType);
	}
	private String chooseRandomShot(Set<String> possibleReturnShots) throws IllegalStateException
	{
		int randomIndex = randomNumberGenerator.nextInt(possibleReturnShots.size());
		
		for (String Shot : possibleReturnShots)
		{
			if(randomIndex == 0)
				return Shot;
			else
				randomIndex--;
		}
		throw new IllegalStateException("Failed to choose a return shot");
	}

	public int returnDrawableShot(String shotType)
	{
		return drawableShotMap.get(shotType);
	}
}