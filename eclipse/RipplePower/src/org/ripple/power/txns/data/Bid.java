package org.ripple.power.txns.data;

import org.json.JSONObject;
import org.ripple.power.config.LSystem;
import org.ripple.power.hft.IMarketOrder;
import org.ripple.power.txns.Const;

public class Bid implements IMarketOrder {
	public String Account;
	public String BookDirectory;
	public String BookNode;
	public int Flags;
	public String LedgerEntryType;
	public String OwnerNode;
	public String owner_funds;
	public String PreviousTxnID;
	public long PreviousTxnLgrSeq;
	public long Sequence;
	public Take TakerGets = new Take();
	public Take TakerPays = new Take();
	public String index;
	public String quality;
	public int Expiration;
	private double Amount = 1;

	@Override
	public double getPrice() {
		if (LSystem.nativeCurrency.equalsIgnoreCase(TakerPays.currency)) {
			return Double.parseDouble(TakerPays.value) / Const.DROPS_IN_XRP;
		} else {
			return Double.parseDouble(TakerPays.value);
		}
	}

	@Override
	public double getAmount() {
		double num = Double.parseDouble(TakerPays.value);
		return num / Amount;
	}

	public void from(JSONObject obj) {
		if (obj != null) {
			System.out.println(obj);
			this.owner_funds = obj.optString("owner_funds");
			this.Account = obj.optString("Account");
			this.PreviousTxnLgrSeq = obj.optLong("PreviousTxnLgrSeq");
			this.OwnerNode = obj.optString("OwnerNode");
			this.index = obj.optString("index");
			this.PreviousTxnID = obj.optString("PreviousTxnID");
			this.TakerGets.from(obj.opt("TakerGets"));
			this.TakerPays.from(obj.opt("TakerPays"));
			this.Flags = obj.optInt("Flags");
			this.Sequence = obj.optLong("Sequence");
			this.quality = obj.optString("quality");
			this.BookDirectory = obj.optString("BookDirectory");
			this.LedgerEntryType = obj.optString("LedgerEntryType");
			this.BookNode = obj.optString("BookNode");
			this.Amount = obj.optDouble("Amount", -1);
			if (Amount <= 0) {
				Amount = Double.parseDouble(quality);
			}
		}
	}

}
