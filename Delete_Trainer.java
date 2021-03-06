
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mongodb.*;

/**
 * 
 * @author yogesh
 */
public class Delete_Trainer extends javax.swing.JFrame implements
		ActionListener {

	/**
	 * Creates new form Delete_Trainer
	 */
	public Delete_Trainer() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("Gym");
			DBCollection Gym_Collection = db.getCollection("trainer");
			DBCursor cursor = Gym_Collection.find();
			String[] First_var = new String[20];
			String[] Second_var = new String[20];
			int i = 0;
			while (cursor.hasNext()) {
				cursor.next();
				First_var[i] = cursor.curr().get("First_Name").toString();
				Second_var[i] = cursor.curr().get("Last_Name").toString();
				i++;
			}
			// JLabel[] labels=new JLabel[20];
			jCheckBox1 = new javax.swing.JCheckBox[20];
			int k = 0, p = 70;
			for (int j = 0; j < i; j++) {
				jCheckBox1[j] = new javax.swing.JCheckBox();

				jCheckBox1[j].setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
				jCheckBox1[j].setForeground(new java.awt.Color(204, 255, 204));

				jCheckBox1[j].setBounds(p, 90 + k, 160, 40);

				if (j % 2 != 0) {
					p = 70;
					k = k + 40;
					jCheckBox1[j].setText(" : " + First_var[j] + " "
							+ Second_var[j]);
					jCheckBox1[j]
							.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
				} else {
					p = 350;
					jCheckBox1[j]
							.setHorizontalTextPosition(SwingConstants.LEFT);
					jCheckBox1[j]
							.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
					jCheckBox1[j].setText(First_var[j] + " " + Second_var[j]
							+ " : ");
				}
				add(jCheckBox1[j]);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jLabel1.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Delete Trainers");
		jLabel1.setForeground(new java.awt.Color(204, 255, 204));
		jLabel1.setBounds(203, 31, 213, 51);
		add(jLabel1);

		jButton1.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
		jButton1.setText("Back");
		jButton1.setBackground(new java.awt.Color(51, 0, 51));
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setBounds(20, 20, 80, 40);
		add(jButton1);
		jButton1.addActionListener(this);

		jButton2.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
		jButton2.setText("Delete_Trainer");
		jButton2.setBackground(new java.awt.Color(51, 0, 51));
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setBounds(190, 620, 190, 40);
		add(jButton2);
		jButton2.addActionListener(this);

		getContentPane().setBackground(new java.awt.Color(88, 0, 0));
		setLayout(null);
		setSize(650, 730);
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Delete_Trainer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Delete_Trainer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Delete_Trainer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Delete_Trainer.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Delete_Trainer().setVisible(true);
			}
		});

	}

	// Variables declaration - do not modify

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jButton1;
	private JButton jButton2;
	private JCheckBox[] jCheckBox1;

	// End of variables declaration
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		add(jLabel2);
		if (ae.getSource() == jButton1) {
			this.setVisible(false);
			new Admin().setVisible(true);
		} else if (ae.getSource() == jButton2) {

			try {
				MongoClient mongo = new MongoClient("localhost", 27017);
				DB db = mongo.getDB("Gym");
				DBCollection Gym_Collection = db.getCollection("trainer");
				DBCollection Batches = db.getCollection("Batch_Trainer");
				DBCursor cursor = Gym_Collection.find();
				String[] First_var = new String[20];
				String[] Second_var = new String[20];
				String[] Batch=new String[20];
				
				DBCursor cur=Batches.find();
                cur.next();
				float Morning=Float.parseFloat(cur.curr().get("Morning").toString());
				float Evening=Float.parseFloat(cur.curr().get("Evening").toString());
				float Night=Float.parseFloat(cur.curr().get("Night").toString());
				float Slots=Float.parseFloat(cur.curr().get("Slots").toString());
				
				int i = 0;
				while (cursor.hasNext()) {
					cursor.next();
					First_var[i] = cursor.curr().get("First_Name").toString();
					Second_var[i] = cursor.curr().get("Last_Name").toString();
					Batch[i]=cursor.curr().get("Batch").toString();
					if (jCheckBox1[i].isSelected()) {
						System.out.println("yes");
						BasicDBObject doc = new BasicDBObject("First_Name",
								First_var[i])
								.append("Last_Name", Second_var[i]);
						DBCursor cursor1 = Gym_Collection.find(doc);
						cursor1.next();
						Gym_Collection.remove(cursor.curr());
						jCheckBox1[i].setSelected(false);
						jLabel2.setFont(new java.awt.Font("SansSerif", 3, 15)); // NOI18N
						jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel2.setText("Deleted Successfully !!! ");
						jLabel2.setForeground(new java.awt.Color(204, 255, 204));
						jLabel2.setBounds(150, 580, 290, 40);
						jCheckBox1[i].setVisible(false);
						
						if(Batch[i].equals("Morning"))
						{
							Morning-=1;
						}
						else if(Batch[i].equals("Evening"))
						{
							Evening-=1;
						}
						else if(Batch[i].equals("Night"))
						{
							Night-=1;
						}
					}
					i++;
				}
				BasicDBObject newDocument = new BasicDBObject();
				newDocument.append("$set",
						new BasicDBObject().append("Morning", Morning)
								.append("Evening", Evening).append("Night",Night));

				BasicDBObject searchQuery = new BasicDBObject().append(
						"Slots", Slots);
                
				Batches.update(searchQuery, newDocument);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
