package lichengzheng.ztrainer;

import java.util.ArrayList;
import java.util.Arrays;

public class ChallengeRallyGenerator
{
    private ArrayList<Integer> challenge1TrainerRowLocationList;
    private ArrayList<Integer> challenge1TrainerColumnLocationList;
    private ArrayList<Integer> challenge1TrainerShotList;
    private ArrayList<Integer> challenge1TraineeRowLocationList;
    private ArrayList<Integer> challenge1TraineeColumnLocationList;
    private ArrayList<Integer> challenge1TraineeShotList;
    private ArrayList<Integer> challenge1ShuttleRowLocationList;
    private ArrayList<Integer> challenge1ShuttleColumnLocationList;
    private ArrayList<Integer> challenge1ShotTimeList;

    private ArrayList<Integer> challenge2TrainerRowLocationList;
    private ArrayList<Integer> challenge2TrainerColumnLocationList;
    private ArrayList<Integer> challenge2TrainerShotList;
    private ArrayList<Integer> challenge2TraineeRowLocationList;
    private ArrayList<Integer> challenge2TraineeColumnLocationList;
    private ArrayList<Integer> challenge2TraineeShotList;
    private ArrayList<Integer> challenge2ShuttleRowLocationList;
    private ArrayList<Integer> challenge2ShuttleColumnLocationList;
    private ArrayList<Integer> challenge2ShotTimeList;

    private ArrayList<Integer> challenge3TrainerRowLocationList;
    private ArrayList<Integer> challenge3TrainerColumnLocationList;
    private ArrayList<Integer> challenge3TrainerShotList;
    private ArrayList<Integer> challenge3TraineeRowLocationList;
    private ArrayList<Integer> challenge3TraineeColumnLocationList;
    private ArrayList<Integer> challenge3TraineeShotList;
    private ArrayList<Integer> challenge3ShuttleRowLocationList;
    private ArrayList<Integer> challenge3ShuttleColumnLocationList;
    private ArrayList<Integer> challenge3ShotTimeList;

    private int challengeChoice;

    public ChallengeRallyGenerator(int challengeChoice)
    {
        this.challengeChoice = challengeChoice;
        initiateChallenge1();
        initiateChallenge2();
        initiateChallenge3();
    }

    private void initiateChallenge1()
    {
        challenge1TrainerRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                2,1,2,2,0,0,3,0,1,0,3,0,2,2,0,0,0,0,0,2,0,3,1,3,0,0,3
            ));
        challenge1TrainerColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                2,2,2,2,0,0,0,1,2,2,0,0,1,2,2,2,2,2,2,0,0,2,2,2,2,2,2
        ));
        challenge1TrainerShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainer_drive,R.drawable.trainer_drive,R.drawable.trainer_lift,R.drawable.trainer_block,R.drawable.trainer_fast_drop,
                R.drawable.trainer_drive,R.drawable.trainer_lift,R.drawable.trainer_fast_clear,R.drawable.trainer_block,R.drawable.trainer_fast_drop,
                R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_lift,R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_clear,
                R.drawable.trainer_clear,R.drawable.trainer_clear,R.drawable.trainer_smash,R.drawable.trainer_lift,R.drawable.trainer_fast_drop,
                R.drawable.trainer_lift,R.drawable.trainer_block,R.drawable.trainer_lift,R.drawable.trainer_clear,R.drawable.trainer_clear
        ));

        challenge1TraineeRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                6,6,7,4,5,6,7,7,5,5,4,7,7,4,7,7,7,7,6,7,5,7,5,7,7,7
        ));
        challenge1TraineeColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                2,2,2,2,2,0,1,2,0,0,0,2,0,2,2,2,2,2,0,1,0,0,2,2,2,2
        ));

        challenge1TraineeShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainee_drive,R.drawable.trainee_block,R.drawable.trainee_fast_drop,R.drawable.trainee_lift,R.drawable.trainee_fast_lift,
                R.drawable.trainee_block,R.drawable.trainee_clear,R.drawable.trainee_smash,R.drawable.trainee_lift,R.drawable.trainee_block,
                R.drawable.trainee_lift,R.drawable.trainee_fast_drop,R.drawable.trainee_fast_drop,R.drawable.trainee_lift,R.drawable.trainee_clear,
                R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_block,R.drawable.trainee_fast_clear,
                R.drawable.trainee_net,R.drawable.trainee_smash,R.drawable.trainee_net,R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_drop
        ));

        challenge1ShuttleRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,2,2,0,0,3,0,1,0,3,0,2,2,0,0,0,0,0,2,0,3,1,3,0,0,3
        ));
        challenge1ShuttleColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                2,2,2,0,0,0,1,2,2,0,0,1,2,2,2,2,2,2,0,0,2,2,2,2,2,2
        ));

        challenge1ShotTimeList =  new ArrayList<Integer>(Arrays.asList(
                880,1350,1830,2222,1900,1700,2350,1390,2120,1910,2350,2500,2175,2250,2550,2850,3120,2950,1550,
                2600,1800,1700,1650,2730,2900,2230
        ));
    }



    private void initiateChallenge2()
    {
        challenge2TrainerRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                2,1,0,0,0,0,0,0,3,0,1,0,0,2,0,2,0,3,0,2,0,1,0,0,0,2,3,1,3,0,3,0,0,0,2,0,2,0,1,1,0,3,0,0,2,0,0,2,1,0,0,3,0,0,0
        ));
        challenge2TrainerColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,1,2,2,2,1,1,2,0,2,2,2,2,2,2,0,1,2,2,1,1,1,0,0,0,0,0,2,2,0,2,2,1,2,2,2,2,2,1,1,0,2,1,1,1,1,2,2,1,2,1,2,0,2,0
        ));
        challenge2TrainerShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainer_drive,R.drawable.trainer_drive,R.drawable.trainer_fast_drop,R.drawable.trainer_fast_drop,
                R.drawable.trainer_clear,R.drawable.trainer_clear,R.drawable.trainer_clear,R.drawable.trainer_fast_drop,
                R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_block,R.drawable.trainer_clear,R.drawable.trainer_smash,
                R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_fast_lift,R.drawable.trainer_fast_drop,R.drawable.trainer_net,
                R.drawable.trainer_jump_smash,R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_block,R.drawable.trainer_fast_drop,
                R.drawable.trainer_smash,R.drawable.trainer_smash,R.drawable.trainer_net,R.drawable.trainer_lift,R.drawable.trainer_block,
                R.drawable.trainer_lift,R.drawable.trainer_fast_drop,R.drawable.trainer_net,R.drawable.trainer_clear,R.drawable.trainer_clear,
                R.drawable.trainer_smash,R.drawable.trainer_net,R.drawable.trainer_smash,R.drawable.trainer_net,R.drawable.trainer_clear,
                R.drawable.trainer_block,R.drawable.trainer_block,R.drawable.trainer_fast_drop,R.drawable.trainer_lift,R.drawable.trainer_fast_drop,
                R.drawable.trainer_smash,R.drawable.trainer_net,R.drawable.trainer_drop,R.drawable.trainer_smash,R.drawable.trainer_drive,
                R.drawable.trainer_block,R.drawable.trainer_clear,R.drawable.trainer_fast_drop,R.drawable.trainer_lift,R.drawable.trainer_fast_drop,
                R.drawable.trainer_smash
        ));

        challenge2TraineeRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                6,6,5,5,7,7,7,5,4,7,5,7,6,4,7,7,5,4,6,4,7,5,5,6,6,4,7,5,7,5,4,7,7,6,4,6,4,7,5,5,5,7,5,6,4,4,6,6,5,7,5,7,5,6
        ));
        challenge2TraineeColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,1,1,1,0,0,2,0,0,2,1,2,1,1,2,0,2,2,0,0,1,1,0,0,0,0,0,2,0,2,2,0,1,2,0,2,1,1,1,0,2,1,0,1,0,0,2,2,0,1,2,0,2,0
        ));

        challenge2TraineeShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainee_drive,R.drawable.trainee_lift,R.drawable.trainee_lift,R.drawable.trainee_lift,R.drawable.trainee_clear,
                R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_net,R.drawable.trainee_lift,R.drawable.trainee_smash,
                R.drawable.trainee_lift,R.drawable.trainee_clear,R.drawable.trainee_block,R.drawable.trainee_lift,R.drawable.trainee_fast_drop,
                R.drawable.trainee_clear,R.drawable.trainee_net,R.drawable.trainee_lift,R.drawable.trainee_block,R.drawable.trainee_lift,
                R.drawable.trainee_smash,R.drawable.trainee_lift,R.drawable.trainee_lift,R.drawable.trainee_lift,R.drawable.trainee_block,
                R.drawable.trainee_net,R.drawable.trainee_smash,R.drawable.trainee_net,R.drawable.trainee_clear,R.drawable.trainee_net,
                R.drawable.trainee_lift,R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_block,R.drawable.trainee_lift,
                R.drawable.trainee_block,R.drawable.trainee_lift,R.drawable.trainee_smash,R.drawable.trainee_drive,R.drawable.trainee_lift,
                R.drawable.trainee_net,R.drawable.trainee_clear,R.drawable.trainee_lift,R.drawable.trainee_block,R.drawable.trainee_lift,
                R.drawable.trainee_lift,R.drawable.trainee_block,R.drawable.trainee_drive,R.drawable.trainee_lift,R.drawable.trainee_clear,
                R.drawable.trainee_net,R.drawable.trainee_clear,R.drawable.trainee_lift,R.drawable.shuttle
        ));

        challenge2ShuttleRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,0,0,0,0,0,0,3,0,1,0,0,2,0,2,0,3,0,2,0,1,0,0,0,2,3,1,3,0,3,0,0,0,2,0,2,0,1,1,0,3,0,0,2,0,0,2,1,0,0,3,0,0,6
        ));
        challenge2ShuttleColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,2,2,2,1,1,2,0,2,2,2,2,2,2,0,1,2,2,1,1,1,0,0,0,0,0,2,2,0,2,2,1,2,2,2,2,2,1,1,0,2,1,1,1,1,2,2,1,2,1,2,0,2,0
        ));

        challenge2ShotTimeList =  new ArrayList<Integer>(Arrays.asList(
               800,1450,2300,2045,2730,2900,3000,1900,2560,2015,2350,2950,1350,2480,2150,2545,1800,2850,1330,2130,1895,2530,
                2400,1430,1250,1900,2500,1830,2800,1800,2950,2600,2650,1250,1950,1250,2100,2000,1250,2100,2120,3000,2200,
                1250,2600,2250,1250,1050,2130,2900,1750,2850,2300,2000
        ));
    }

    private void initiateChallenge3()
    {
        challenge3TrainerRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,0,2,0,0,2,0,1,3,1,0,1,0,0,0,0,2,0,1,0,0,0,0,0,3,1,2,0,3,0,2,0,0,2,0,0,1,3
        ));
        challenge3TrainerColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,0,1,0,2,0,0,0,1,2,0,0,0,0,0,0,2,2,2,0,2,0,2,2,2,0,2,2,0,0,0,0,0,2,0,2,2,0
        ));
        challenge3TrainerShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainer_serve,R.drawable.trainer_smash,R.drawable.trainer_net,R.drawable.trainer_fast_drop,
                R.drawable.trainer_clear,R.drawable.trainer_block,R.drawable.trainer_clear,R.drawable.trainer_block,
                R.drawable.trainer_fast_lift,R.drawable.trainer_block,R.drawable.trainer_clear,R.drawable.trainer_block,
                R.drawable.trainer_clear,R.drawable.trainer_clear,R.drawable.trainer_clear,R.drawable.trainer_clear,
                R.drawable.trainer_block,R.drawable.trainer_clear,R.drawable.trainer_lift,R.drawable.trainer_fast_drop,
                R.drawable.trainer_clear,R.drawable.trainer_smash,R.drawable.trainer_clear,R.drawable.trainer_drop,
                R.drawable.trainer_lift,R.drawable.trainer_lift,R.drawable.trainer_block,R.drawable.trainer_clear,
                R.drawable.trainer_lift,R.drawable.trainer_clear,R.drawable.trainer_lift,R.drawable.trainer_drop,
                R.drawable.trainer_fast_drop,R.drawable.trainer_lift,R.drawable.trainer_clear,R.drawable.trainer_clear,
                R.drawable.trainer_block
        ));

        challenge3TraineeRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                6,6,4,5,7,5,7,5,7,5,7,5,7,7,7,7,5,7,7,5,7,6,7,4,7,7,5,7,7,7,7,4,5,7,7,7,5
        ));
        challenge3TraineeColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                1,1,0,1,2,0,0,1,2,2,1,0,0,1,0,0,2,2,1,0,0,2,2,0,0,0,2,0,0,2,0,0,2,0,0,1,0
        ));

        challenge3TraineeShotList =  new ArrayList<Integer>(Arrays.asList(
                R.drawable.trainee_lift,R.drawable.trainee_block,R.drawable.trainee_lift,R.drawable.trainee_lift,
                R.drawable.trainee_fast_drop,R.drawable.trainee_fast_lift,R.drawable.trainee_smash,R.drawable.trainee_net,
                R.drawable.trainee_drive,R.drawable.trainee_fast_lift,R.drawable.trainee_smash,R.drawable.trainee_lift,
                R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_fast_drop,
                R.drawable.trainee_lift,R.drawable.trainee_smash,R.drawable.trainee_fast_clear,R.drawable.trainee_lift,
                R.drawable.trainee_clear,R.drawable.trainee_lift,R.drawable.trainee_clear,R.drawable.trainee_net,
                R.drawable.trainee_smash,R.drawable.trainee_fast_drop,R.drawable.trainee_lift,R.drawable.trainee_drop,
                R.drawable.trainee_clear,R.drawable.trainee_fast_drop,R.drawable.trainee_clear,R.drawable.trainee_lift,
                R.drawable.trainee_block,R.drawable.trainee_clear,R.drawable.trainee_clear,R.drawable.trainee_smash,R.drawable.trainee_net
        ));

        challenge3ShuttleRowLocationList =  new ArrayList<Integer>(Arrays.asList(
                0,2,0,0,2,0,1,3,1,0,1,0,0,0,0,2,0,1,0,0,0,0,0,3,1,2,0,3,0,2,0,0,2,0,0,1,3
        ));
        challenge3ShuttleColumnLocationList =  new ArrayList<Integer>(Arrays.asList(
                0,1,0,2,0,0,0,1,2,0,0,0,0,0,0,2,2,2,0,2,0,2,2,2,0,2,2,0,0,0,0,0,2,0,2,2,0
        ));

        challenge3ShotTimeList =  new ArrayList<Integer>(Arrays.asList(
                1780,998,2102,1655,1820,2209,1598,1773,1706,1603,1598,2084,2457,2528,2178,2307,2319,2263,1757,1872,2596,
                1752,2018,1839,1920,2020,2140,2425,2455,2650,2765,2084,2084,2720,2361,2285,2252
        ));
    }
    public int getRallyLength()
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TraineeColumnLocationList.size();
            case 2:
                return challenge2TraineeColumnLocationList.size();
            case 3:
                return challenge3TraineeColumnLocationList.size();
                default:
                    return challenge1TraineeColumnLocationList.size();
        }
    }
    public int getTrainerColumnLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TrainerColumnLocationList.get(index);
            case 2:
                return challenge2TrainerColumnLocationList.get(index);
            case 3:
                return challenge3TrainerColumnLocationList.get(index);
            default:
                return challenge1TrainerColumnLocationList.get(index);
        }
    }
    public int getTrainerRowLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TrainerRowLocationList.get(index);
            case 2:
                return challenge2TrainerRowLocationList.get(index);
            case 3:
                return challenge3TrainerRowLocationList.get(index);
            default:
                return challenge1TrainerRowLocationList.get(index);
        }
    }
    public int getTraineeColumnLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TraineeColumnLocationList.get(index);
            case 2:
                return challenge2TraineeColumnLocationList.get(index);
            case 3:
                return challenge3TraineeColumnLocationList.get(index);
            default:
                return challenge1TraineeColumnLocationList.get(index);
        }
    }
    public int getTraineeRowLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TraineeRowLocationList.get(index);
            case 2:
                return challenge2TraineeRowLocationList.get(index);
            case 3:
                return challenge3TraineeRowLocationList.get(index);
            default:
                return challenge1TraineeRowLocationList.get(index);
        }
    }
    public int getShotColumnLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1ShuttleColumnLocationList.get(index);
            case 2:
                return challenge2ShuttleColumnLocationList.get(index);
            case 3:
                return challenge3ShuttleColumnLocationList.get(index);
            default:
                return challenge1ShuttleColumnLocationList.get(index);
        }
    }
    public int getShotRowLocation(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1ShuttleRowLocationList.get(index);
            case 2:
                return challenge2ShuttleRowLocationList.get(index);
            case 3:
                return challenge3ShuttleRowLocationList.get(index);
            default:
                return challenge1ShuttleRowLocationList.get(index);
        }
    }
    public int getTrainerShotDrawable(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TrainerShotList.get(index);
            case 2:
                return challenge2TrainerShotList.get(index);
            case 3:
                return challenge3TrainerShotList.get(index);
            default:
                return challenge1TrainerShotList.get(index);
        }
    }
    public int getTraineeShotDrawable(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1TraineeShotList.get(index);
            case 2:
                return challenge2TraineeShotList.get(index);
            case 3:
                return challenge3TraineeShotList.get(index);
            default:
                return challenge1TraineeShotList.get(index);
        }
    }
    public int getShotTime(int index)
    {
        switch(challengeChoice)
        {
            case 1:
                return challenge1ShotTimeList.get(index);
            case 2:
                return challenge2ShotTimeList.get(index);
            case 3:
                return challenge3ShotTimeList.get(index);
            default:
                return challenge1ShotTimeList.get(index);
        }
    }
}
