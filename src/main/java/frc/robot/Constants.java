package frc.robot;

public final class Constants {

    public static final class DriveConstants {
        public static final int FRONT_LEFT_ID = 1;
        public static final int BACK_LEFT_ID = 2;
        public static final int FRONT_RIGHT_ID = 3;
        public static final int BACK_RIGHT_ID = 4;

        public static final double MAX_FORWARD_SPEED = 0.7;
        public static final double MAX_TURN_SPEED = 0.8;
    }

    public static final class IntakeConstants {
        public static final int MOTOR_ID = 5;
        public static final double IN_SPEED = 0.4;
        public static final double OUT_SPEED = -0.4;
        public static final double STALL_SPEED = 0.2;
    }

    public static final class OIConstants {
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final int INTAKE_IN_BUTTON = 1;
        public static final int INTAKE_OUT_BUTTON = 2;
    }
}
