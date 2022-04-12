public class CharacterState {
    public CharacterState(int feedValue,int playValue,int sleepValue,int cleanValue) {
        this.feedValue=feedValue;
        this.playValue=playValue;
        this.sleepValue=sleepValue;
        this.cleanValue=cleanValue;
    }
    public CharacterState() {
    }
    public int feedValue;
    public int playValue;
    public int sleepValue;
    public int cleanValue;
}