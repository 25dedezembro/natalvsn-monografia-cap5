import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;
 
 
public class Inimigo {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private int size;
	private int prob;
	
	private Random rand = new Random();
 
	public Inimigo(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		prob = rand.nextInt(10);
		while(this.dx==0)
			this.dx = rand.nextDouble()*2-1;
		while(this.dy==0)
			this.dy = rand.nextDouble()*2-1;
 
	}
 
	public void move() {
	
		x += dx;
		y += dy;
 
		

		if(prob<8){
			if(x>Ambiente.XJogador)
				x--;
			else
				x++;
			
			if(y>Ambiente.YJogador)
				y--;
			else
				y++;		
		}

		if(Ambiente.jogador.getTiros().size() > 0){
			for(int i=0; i<Ambiente.jogador.getTiros().size();i++){
				if(Ambiente.jogador.getTiros().get(i).getDir() == 1 &&
						Ambiente.jogador.getTiros().get(i).getX() > x && 
						Math.abs(y - Ambiente.jogador.getTiros().get(i).getY()) < 50){
					y+=-1;
				} else if(Ambiente.jogador.getTiros().get(i).getDir() == 2 &&
						Ambiente.jogador.getTiros().get(i).getX() < x &&						
						Math.abs(y - Ambiente.jogador.getTiros().get(i).getY())<50){
					y+=-1;
				} else if(Ambiente.jogador.getTiros().get(i).getDir() == 3 &&
						Ambiente.jogador.getTiros().get(i).getY() > y &&
						Math.abs(x - Ambiente.jogador.getTiros().get(i).getX())<50){
					x+=-1;
				} else if(Ambiente.jogador.getTiros().get(i).getDir() == 4 &&
						Ambiente.jogador.getTiros().get(i).getY() < y &&
						Math.abs(x - Ambiente.jogador.getTiros().get(i).getX())<50){
					x+=-1;
				}
			}
		} else {
									
			if(x <= 0) {
				x = Ambiente.largura;
			} else if (x >= Ambiente.largura) {
				x = 0;
			}
			if(y <= 0) {
				y = Ambiente.altura;
			} else if(y >= Ambiente.altura) {
				y = 0;
			}
		}
		
	}
 
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval((int)x, (int)y, size, size);
		g.fillOval((int)x, (int)y, size, size);
	}
 
	public double getX() {
		return x;
	}
 
	public void setX(int x) {
		this.x = x;
	}
 
	public double getY() {
		return y;
	}
 
	public void setY(int y) {
		this.y = y;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public Random getRand() {
		return rand;
	}
 
	public void setRand(Random rand) {
		this.rand = rand;
	}
}

