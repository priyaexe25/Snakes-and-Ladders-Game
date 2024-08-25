package sample;

public class Snakesnladders{

    public void ladders(player p) {


        if (p.x == 120 && p.y == 0) {            //LADDER 4 to 26
            p.x += 80;
            p.y -= 80;               //resets positionition counter (relative movement ie steps moved )

            p.position += 2;                              // if start and destination rows both not odd or both even, positionCir -- is required
        }

        if (p.x == 280 && p.y == 0) {            //LADDER 8 to 51
            p.y = -200;
            p.x += 80;

            p.position = p.position + 5;

        }

        if (p.x == 280 && p.y == -80) {            //LADDER 28 to 46
            p.y = -160;
            p.x -= 80;

            p.position = p.position + 2;
        }
        if (p.x == 40 && p.y == -120) {            //LADDER 39 to 60
            p.y = -200;
            p.x = 0;
            p.position = p.position + 2;
        }
        if (p.x == 120 && p.y == -160) {            //LADDER 44 to 80
            p.y = -280;
            p.x = 0;
            p.position = p.position + 3;
        }
        if (p.x == 120 && p.y == -240) {            //LADDER 64 to 85
            p.y -= 80;
            p.x += 40;
            p.position = p.position + 2;
        }
        if (p.x == 120 && p.y == -320) {            //LADDER 84 to 98
            p.y -= 40;
            p.x -= 40;
            p.position = p.position + 1;
        }

        if (p.x == 320 && p.y == -200) {            //LADDER 52 to 68
            p.y -= 40;
            p.x -= 40;
            p.position = p.position + 1;
        }

        if (p.x == 320 && p.y == -240) {            //LADDER 69 to 93
            p.y = -360;
            p.x -= 40;
            p.position = p.position + 3;
        }
        if (p.x == 360 && p.y == -280) {            //LADDER 71 to 92
            p.y = -360;
            p.x -= 40;
            p.position = p.position + 2;
        }




    }

    public void snakes(player p) {


        if (p.x == 360 && p.y == -40) {            //SNAKE 11 to 9
            p.x -= 40;
            p.y += 40;               //resets position counter (relative movement ie steps moved )

            p.position--;                              // if start and destination rows both not odd or both even, posCir -- is required
        }

        if (p.x == 160 && p.y == -120) {            //SNAKE 36 to 14
            p.y += 80;
            p.x += 80;

            p.position = p.position - 2;

        }

        if (p.x == 80 && p.y == -160) {            //SNAKE 43 to 22
            p.y += 80;
            p.x -= 40;

            p.position = p.position - 2;
        }
        if (p.x == 120 && p.y == -200) {            //SNAKE 57 to 9
            p.y = -40;
            p.x = 40;
            p.position = p.position - 4;
        }
        if (p.x == 200 && p.y == -240) {            //SNAKE 66 to 47
            p.y += 80;
            p.x += 40;
            p.position = p.position - 2;
        }
        if (p.x == 0 && p.y == -320) {            //SNAKE 81 to 63
            p.y += 80;
            p.x += 80;
            p.position = p.position - 2;
        }
        if (p.x == 360 && p.y == -320) {            //SNAKE 90 to 49
            p.y += 160;
            p.x -= 40;
            p.position = p.position - 4;
        }
        if (p.x == 240 && p.y == -360) {            //SNAKE 94 to 48
            p.y += 200;
            p.x += 40;
            p.position = p.position - 5;
        }
        if (p.x == 160 && p.y == -360) {            //SNAKE 96 to 65
            p.y += 120;
            p.position = p.position - 3;
        }

        if (p.x == 40 && p.y == -360) {            //SNAKE 99 to 78
            p.y += 80;
            p.x += 40;
            p.position = p.position - 2;
        }



    }
}