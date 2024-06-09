/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author liksh
 */
public class PlayerContract implements Comparable<PlayerContract> {

    public String playerName;
    public Integer contractDuration;
    public Double compositeMark;

    public PlayerContract(String playerName, Integer contractDuration, Double compositeMark) {
        this.playerName = playerName;
        this.contractDuration = contractDuration;
        this.compositeMark = compositeMark;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Integer getContractDuration() {
        return this.contractDuration;
    }

    public Double getCompositeMark() {
        return this.compositeMark;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setContractDuration(Integer contractDuration) {
        this.contractDuration = contractDuration;
    }

    public void setCompositeMark(Double compositeMark) {
        this.compositeMark = compositeMark;
    }

    @Override
    public int compareTo(PlayerContract o) {
        return this.getCompositeMark().compareTo(o.getCompositeMark());
    }

    public String toString() {
        return "Player: " + this.playerName + " Contract duration: " + this.contractDuration + " Composite mark: " + this.compositeMark + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayerContract that = (PlayerContract) obj;
        return contractDuration == that.contractDuration
                && Double.compare(that.compositeMark, compositeMark) == 0
                && playerName.equals(that.playerName);
    }

}
