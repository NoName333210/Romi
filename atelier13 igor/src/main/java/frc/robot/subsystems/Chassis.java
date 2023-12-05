package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class Chassis extends SubsystemBase {
  PWMVictorSPX leftMotor;
  PWMVictorSPX rightMotor;
  DifferentialDrive diffDrive;
  Encoder leftEncoder;
  Encoder rightEncoder;

  public Chassis() {
    // les moteurs du Romi sont des Victor SPX...
    leftMotor = new PWMVictorSPX(0);
    rightMotor = new PWMVictorSPX(1);

    // il faut inverser un des deux  moteurs... pour que ça roule droit!


    // maintenant on construit un drive qui regroupe les deux  moteurs
    diffDrive = new DifferentialDrive(leftMotor,rightMotor);

    // on affiche cette variable dans le smart dashboard
    SmartDashboard.putData(getName(), diffDrive);

    // désactive la sécurité (système de timout non nécessaire pour cet exemple)
    diffDrive.setSafetyEnabled(false);

    // création de l'encodeur de gauche, direction reversée
    leftEncoder = new Encoder(4, 5);
    // sans oublier la distance par impulsion...
    leftEncoder.setDistancePerPulse(13);

    // on affiche cette variable dans le smart dashboard
    SmartDashboard.putData(leftEncoder);

    // création de l'encodeur de droite lui aussi avec la direction reversée
    rightEncoder = new Encoder(6, 7);
    // sans oublier la distance par impulsion...
   rightEncoder.setDistancePerPulse(13);;

    // on affiche cette variable dans le smart dashboard
    SmartDashboard.putData(rightEncoder);
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
  }

  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public double getRightDistance() {
    return rightEncoder.getDistance();
  }

  public void drive(double speed, double direction) {
    // on utilise un drive de type arcade...
  diffDrive.arcadeDrive(speed, direction);
  }

  public void drive(double speed, double direction, boolean squaredInputs) {
    // on utilise un drive de type arcade...
    diffDrive.arcadeDrive(speed, direction, squaredInputs);
  }

  public void reset() {
    // remise à 0 des deux encodeurs
    rightEncoder.reset();
    leftEncoder.reset();
  }

  public void stop() {
    // on met le drive à 0 vitesse et 0 direction...
    RobotContainer.chassis.drive(0, 0);
  }

  public void addChild(double d) {
  }
}
