/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Turn extends CommandBase {

  // on utilise des distances en pouces... oh well
  double inches;
  double turnSpeed;

  public Turn(double angle) {
    // on indique qu'on a besoin du chassis
    

    // un peu de math pour calculer la distance à parcourir
    inches = Math.abs(angle) * Math.PI * Constants.wheelTrack / 360.0;
    // calcul de la vitesse dans le bon sens... suggestion 10%
    turnSpeed = 10;
  }

  @Override
  public void initialize() {
    // à l'initialisation de la commande, on remet le chassis à 0
   RobotContainer.chassis.reset();
  }

  @Override
  public void execute() {
    // on ne parcourt pas vraiment de distance mais on tourne...
    RobotContainer.chassis.getLeftDistance();
  }

  @Override
  public void end(boolean interrupted) {
    // quand la commande a terminée, on arrête le chassis
    RobotContainer.chassis.stop();
  }

  @Override
  public boolean isFinished() {
    // quand une des roues à parcourue la distance souhaitée, c'est fini
    return Math.abs(RobotContainer.chassis.getRightDistance()) >= inches;
  }
}
