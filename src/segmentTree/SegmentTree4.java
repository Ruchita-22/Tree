package segmentTree;

public class SegmentTree4 {
	static int seg[];
	static int arr[];
	public static void main(String[] args) {
		
	}
	private static void solve(int givenArray[], int[][] queries) {
		arr = givenArray;
		int n = arr.length;
		seg = new int[n];
		build(0,0, n-1);
		for(int query[] : queries) {
			if(query[0] == 1) update(0,0,n-1, query[1], query[2]);
			else System.out.println(query(0,0, n-1,query[1], query[2]));
		}
		
	}
	private static void build(int idx, int l, int r) {
		// TODO Auto-generated method stub
		if(l == r) {
			seg[idx] = arr[l];
			return;
		}
		
		int m = (l+r)/2;
		build(2*idx+1,l, m);
		build(2*idx+2, m+1, r);
		seg[idx] = seg[2*idx+1] + seg[2*idx+2];

	}
	private static void update(int idx, int l, int r, int i, int val) {
		// TODO Auto-generated method stub
		if(l == r) {
			arr[i] = val;
			seg[idx] = val;
			return;
		}
		
		int m = (l+r)/2;
		if(i <= m)		update(2*idx+1,l, m, i, val);
		else 			update(2*idx+2, m+1, r, i , val);
		seg[idx] = seg[2*idx+1] + seg[2*idx+2];

	}
	private static int query(int idx, int l, int r, int ql, int qr) {
		// TODO Auto-generated method stub
		if(ql > r || qr < l)	return 0;
		if(ql <= l && qr >= r )	return seg[idx];
		int m = (l+r)/2;
		return query(2*idx+1,l, m, ql, qr) + query(2*idx+2,l, m, ql, qr);		
		
	}

}
