//Brianna Moffett
//CS 272
//10.17.19
//lab 8
public class SNode <E> {
	private E data; 
	private SNode<E> link;
	private E head;
	
	public static void main(String[] args) {

	}
	//SNode methods
	public SNode() {
		this.setData(null);
		this.link = null;
	}
	public SNode(E _data, SNode _link) { 
		this.setData(_data);
	    this.link = _link;
	}
	public void setNodeValue (E data) { 
		this.setData(data);
	}
	public E getNodeValue () { 
		return getData();
	}
	public void setLink (SNode link) { 
		this.link = link;
	}
	public SNode getLink () { 
		return link;
	}
	public void addNodeAfterThis(E newdata) { 
		this.setLink(new SNode<E>(newdata, this.link));
	}
	public void removeNodeAfterThis () { 
		this.link = this.link.link;
	}
	@SuppressWarnings("unused")
	public int ListLength() { 
		int count = 0;
		SNode<E> cursor = this;
		while (cursor != null) {
			if (cursor == null) {
				return count;
			}
			cursor = cursor.link;
			count++;
		}
		return count;
	}

	public void addToEnd (E newdata) {
		this.setLink(new SNode<E>(newdata, this.link));
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
}
