package group.Macsed.TankBattle.Foundation.Graphics.Data;

public class RenderDataUnit {

    public float Xposition;
    public float Yposition;

    public float width;
    public float height;

    public String path;

    public RenderDataUnit(String path,float xposition,float yposition,float width,float height){
        this.height = height;
        this.width = width;
        this.Xposition = xposition;
        this.Yposition = yposition;
        this.path = path;

    }




}
