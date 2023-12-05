/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.Forward;
import frc.robot.commands.Labyrinth;
import frc.robot.commands.Turn;
import frc.robot.subsystems.Chassis;

/**
 * Il s'agit de la classe qui contient la majorité des déclarations des
 * sous-systèmes et qui attachent les boutons du smart dashboard à différentes 
 * commandes.
 */
public class RobotContainer {
  // le chassis devrait être déclaré ici
  public static final Chassis chassis = new Chassis();
  // un joystick sur le port 0 devrait être déclarés ici
  public static final Joystick joystick = new Joystick(0);

   // Le constructeur devrait contenir les assignations de bouton et la création
   // d'une commande par défaut
  public RobotContainer() {
    SmartDashboard.putData("move forward", new Forward(13)); // aller de l'avant de 13 pouces
    SmartDashboard.putData("turn left", new Turn(-90)); // tourner à gauche de 90 degrés
    SmartDashboard.putData("turn right", new Turn(90)); // tourner à droite de 90 degrés
    SmartDashboard.putData("start the labyrinth",new Labyrinth()); //  appeler la commande Labyrinth

    chassis.setDefaultCommand(new DefaultDrive());
  }

   // nous n'utilisons pas "encore" le mode autonome
  public Command getAutonomousCommand() {
    return null;
  }
}
