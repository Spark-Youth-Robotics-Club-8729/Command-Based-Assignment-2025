package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstats;

public class IntakeSubsystem extends SubsystemBase{
    private final SparkMax m_intakemotor=new SparkMax(IntakeConstats.intakemotorid, MotorType.kBrushless);
    public IntakeSubsystem(){

    }
    public void intake(){
        m_intakemotor.set(IntakeConstats.in);
    }
    public void outtake(){
        m_intakemotor.set(IntakeConstats.out);

    }

    public void run(double speed) {
        m_intakemotor.set(speed);
    }
    public void stop(){
        m_intakemotor.set(0);
    }
    public double getMotorOutput(){
        return m_intakemotor.get();
    }


}
