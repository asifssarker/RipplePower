package org.bootstrap.style;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.ripple.power.ui.UIRes;

public class FontStyle {
	private Font font;

	private FontStyle() {
		InputStream fontStream = null;
		try {
			fontStream = UIRes.getStream("fonts/webfont.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fontStream != null) {
				try {
					fontStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class LazyHolder {
		private static final FontStyle INSTANCE = new FontStyle();
	}

	public static FontStyle getInstance() {
		return LazyHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}

	public Font getFont() {
		return font;
	}

	public enum Icon {
		GLASS('\uf000'), MUSIC('\uf001'), SEARCH('\uf002'), ENVELOPE_O('\uf003'), HEART(
				'\uf004'), STAR('\uf005'), STAR_O('\uf006'), USER('\uf007'), FILM(
				'\uf008'), TH_LARGE('\uf009'), TH('\uf00a'), TH_LIST('\uf00b'), CHECK(
				'\uf00c'), TIMES('\uf00d'), SEARCH_PLUS('\uf00e'), SEARCH_MINUS(
				'\uf010'), POWER_OFF('\uf011'), SIGNAL('\uf012'), GEAR('\uf013'), COG(
				'\uf013'), TRASH_O('\uf014'), HOME('\uf015'), FILE_O('\uf016'), CLOCK_O(
				'\uf017'), ROAD('\uf018'), DOWNLOAD('\uf019'), ARROW_CIRCLE_O_DOWN(
				'\uf01a'), ARROW_CIRCLE_O_UP('\uf01b'), INBOX('\uf01c'), PLAY_CIRCLE_O(
				'\uf01d'), ROTATE_RIGHT('\uf01e'), REPEAT('\uf01e'), REFRESH(
				'\uf021'), LIST_O('\uf022'), LOCK('\uf023'), FLAG('\uf024'), HEADPHONES(
				'\uf025'), VOLUME_OFF('\uf026'), VOLUME_DOWN('\uf027'), VOLUME_UP(
				'\uf028'), QRCODE('\uf029'), BARCODE('\uf02a'), TAG('\uf02b'), TAGS(
				'\uf02c'), BOOK('\uf02d'), BOOKMARK('\uf02e'), PRINT('\uf02f'), CAMERA(
				'\uf030'), FONT('\uf031'), BOLD('\uf032'), ITALIC('\uf033'), TEXT_HEIGHT(
				'\uf034'), TEXT_WIDTH('\uf035'), ALIGN_LEFT('\uf036'), ALIGN_CENTER(
				'\uf037'), ALIGN_RIGHT('\uf038'), ALIGN_JUSTIFY('\uf039'), LIST(
				'\uf03a'), DEDENT('\uf03b'), OUTDENT('\uf03b'), INDENT('\uf03c'), VIDEO_CAMERA(
				'\uf03d'), PICTURE_O('\uf03e'), PENCIL('\uf040'), MAP_MARKER(
				'\uf041'), ADJUST('\uf042'), TINT('\uf043'), EDIT('\uf044'), PENCIL_SQUARE_O(
				'\uf044'), SHARE_SQUARE_O('\uf045'), CHECK_SQUARE_O('\uf046'), MOVE(
				'\uf047'), STEP_BACKWARD('\uf048'), FAST_BACKWARD('\uf049'), BACKWARD(
				'\uf04a'), PLAY('\uf04b'), PAUSE('\uf04c'), STOP('\uf04d'), FORWARD(
				'\uf04e'), FAST_FORWARD('\uf050'), STEP_FORWARD('\uf051'), EJECT(
				'\uf052'), CHEVRON_LEFT('\uf053'), CHEVRON_RIGHT('\uf054'), PLUS_CIRCLE(
				'\uf055'), MINUS_CIRCLE('\uf056'), TIMES_CIRCLE('\uf057'), CHECK_CIRCLE(
				'\uf058'), QUESTION_CIRCLE('\uf059'), INFO_CIRCLE('\uf05a'), CROSSHAIRS(
				'\uf05b'), TIMES_CIRCLE_O('\uf05c'), CHECK_CIRCLE_O('\uf05d'), BAN(
				'\uf05e'), ARROW_LEFT('\uf060'), ARROW_RIGHT('\uf061'), ARROW_UP(
				'\uf062'), ARROW_DOWN('\uf063'), MAIL_FORWARD('\uf064'), SHARE(
				'\uf064'), RESIZE_FULL('\uf065'), RESIZE_SMALL('\uf066'), PLUS(
				'\uf067'), MINUS('\uf068'), ASTERISK('\uf069'), EXCLAMATION_CIRCLE(
				'\uf06a'), GIFT('\uf06b'), LEAF('\uf06c'), FIRE('\uf06d'), EYE(
				'\uf06e'), EYE_SLASH('\uf070'), WARNING('\uf071'), EXCLAMATION_TRIANGLE(
				'\uf071'), PLANE('\uf072'), CALENDAR('\uf073'), RANDOM('\uf074'), COMMENT(
				'\uf075'), MAGNET('\uf076'), CHEVRON_UP('\uf077'), CHEVRON_DOWN(
				'\uf078'), RETWEET('\uf079'), SHOPPING_CART('\uf07a'), FOLDER(
				'\uf07b'), FOLDER_OPEN('\uf07c'), RESIZE_VERTICAL('\uf07d'), RESIZE_HORIZONTAL(
				'\uf07e'), BAR_CHART_O('\uf080'), TWITTER_SQUARE('\uf081'), FACEBOOK_SQUARE(
				'\uf082'), CAMERA_RETRO('\uf083'), KEY('\uf084'), GEARS(
				'\uf085'), COGS('\uf085'), COMMENTS('\uf086'), THUMBS_O_UP(
				'\uf087'), THUMBS_O_DOWN('\uf088'), STAR_HALF('\uf089'), HEART_O(
				'\uf08a'), SIGN_OUT('\uf08b'), LINKEDIN_SQUARE('\uf08c'), THUMB_TACK(
				'\uf08d'), EXTERNAL_LINK('\uf08e'), SIGN_IN('\uf090'), TROPHY(
				'\uf091'), GITHUB_SQUARE('\uf092'), UPLOAD('\uf093'), LEMON_O(
				'\uf094'), PHONE('\uf095'), SQUARE_O('\uf096'), BOOKMARK_O(
				'\uf097'), PHONE_SQUARE('\uf098'), TWITTER('\uf099'), FACEBOOK(
				'\uf09a'), GITHUB('\uf09b'), UNLOCK('\uf09c'), CREDIT_CARD(
				'\uf09d'), RSS('\uf09e'), HDD_O('\uf0a0'), BULLHORN('\uf0a1'), BELL(
				'\uf0f3'), CERTIFICATE('\uf0a3'), HAND_O_RIGHT('\uf0a4'), HAND_O_LEFT(
				'\uf0a5'), HAND_O_UP('\uf0a6'), HAND_O_DOWN('\uf0a7'), ARROW_CIRCLE_LEFT(
				'\uf0a8'), ARROW_CIRCLE_RIGHT('\uf0a9'), ARROW_CIRCLE_UP(
				'\uf0aa'), ARROW_CIRCLE_DOWN('\uf0ab'), GLOBE('\uf0ac'), WRENCH(
				'\uf0ad'), TASKS('\uf0ae'), FILTER('\uf0b0'), BRIEFCASE(
				'\uf0b1'), FULLSCREEN('\uf0b2'), GROUP('\uf0c0'), CHAIN(
				'\uf0c1'), LINK('\uf0c1'), CLOUD('\uf0c2'), FLASK('\uf0c3'), CUT(
				'\uf0c4'), SCISSORS('\uf0c4'), COPY('\uf0c5'), FILES_O('\uf0c5'), PAPERCLIP(
				'\uf0c6'), SAVE('\uf0c7'), FLOPPY_O('\uf0c7'), SQUARE('\uf0c8'), REORDER(
				'\uf0c9'), LIST_UL('\uf0ca'), LIST_OL('\uf0cb'), STRIKETHROUGH(
				'\uf0cc'), UNDERLINE('\uf0cd'), TABLE('\uf0ce'), MAGIC('\uf0d0'), TRUCK(
				'\uf0d1'), PINTEREST('\uf0d2'), PINTEREST_SQUARE('\uf0d3'), GOOGLE_PLUS_SQUARE(
				'\uf0d4'), GOOGLE_PLUS('\uf0d5'), MONEY('\uf0d6'), CARET_DOWN(
				'\uf0d7'), CARET_UP('\uf0d8'), CARET_LEFT('\uf0d9'), CARET_RIGHT(
				'\uf0da'), COLUMNS('\uf0db'), UNSORTED('\uf0dc'), SORT('\uf0dc'), SORT_DOWN(
				'\uf0dd'), SORT_ASC('\uf0dd'), SORT_UP('\uf0de'), SORT_DESC(
				'\uf0de'), ENVELOPE('\uf0e0'), LINKEDIN('\uf0e1'), ROTATE_LEFT(
				'\uf0e2'), UNDO('\uf0e2'), LEGAL('\uf0e3'), GAVEL('\uf0e3'), DASHBOARD(
				'\uf0e4'), TACHOMETER('\uf0e4'), COMMENT_O('\uf0e5'), COMMENTS_O(
				'\uf0e6'), FLASH('\uf0e7'), BOLT('\uf0e7'), SITEMAP('\uf0e8'), UMBRELLA(
				'\uf0e9'), PASTE('\uf0ea'), CLIPBOARD('\uf0ea'), LIGHTBULB_O(
				'\uf0eb'), EXCHANGE('\uf0ec'), CLOUD_DOWNLOAD('\uf0ed'), CLOUD_UPLOAD(
				'\uf0ee'), USER_MD('\uf0f0'), STETHOSCOPE('\uf0f1'), SUITCASE(
				'\uf0f2'), BELL_O('\uf0a2'), COFFEE('\uf0f4'), CUTLERY('\uf0f5'), FILE_TEXT_O(
				'\uf0f6'), BUILDING('\uf0f7'), HOSPITAL('\uf0f8'), AMBULANCE(
				'\uf0f9'), MEDKIT('\uf0fa'), FIGHTER_JET('\uf0fb'), BEER(
				'\uf0fc'), H_SQUARE('\uf0fd'), PLUS_SQUARE('\uf0fe'), ANGLE_DOUBLE_LEFT(
				'\uf100'), ANGLE_DOUBLE_RIGHT('\uf101'), ANGLE_DOUBLE_UP(
				'\uf102'), ANGLE_DOUBLE_DOWN('\uf103'), ANGLE_LEFT('\uf104'), ANGLE_RIGHT(
				'\uf105'), ANGLE_UP('\uf106'), ANGLE_DOWN('\uf107'), DESKTOP(
				'\uf108'), LAPTOP('\uf109'), TABLET('\uf10a'), MOBILE_PHONE(
				'\uf10b'), MOBILE('\uf10b'), CIRCLE_O('\uf10c'), QUOTE_LEFT(
				'\uf10d'), QUOTE_RIGHT('\uf10e'), SPINNER('\uf110'), CIRCLE(
				'\uf111'), MAIL_REPLY('\uf112'), REPLY('\uf112'), GITHUB_O(
				'\uf113'), FOLDER_O('\uf114'), FOLDER_OPEN_O('\uf115'), SMILE_O(
				'\uf118'), FROWN_O('\uf119'), MEH_O('\uf11a'), GAMEPAD('\uf11b'), KEYBOARD_O(
				'\uf11c'), FLAG_O('\uf11d'), FLAG_CHECKERED('\uf11e'), TERMINAL(
				'\uf120'), CODE('\uf121'), REPLY_ALL('\uf122'), MAIL_REPLY_ALL(
				'\uf122'), STAR_HALF_EMPTY('\uf123'), STAR_HALF_FULL('\uf123'), STAR_HALF_O(
				'\uf123'), LOCATION_ARROW('\uf124'), CROP('\uf125'), CODE_FORK(
				'\uf126'), UNLINK('\uf127'), CHAIN_BROKEN('\uf127'), QUESTION(
				'\uf128'), INFO('\uf129'), EXCLAMATION('\uf12a'), SUPERSCRIPT(
				'\uf12b'), SUBSCRIPT('\uf12c'), ERASER('\uf12d'), PUZZLE_PIECE(
				'\uf12e'), MICROPHONE('\uf130'), MICROPHONE_SLASH('\uf131'), SHIELD(
				'\uf132'), CALENDAR_O('\uf133'), FIRE_EXTINGUISHER('\uf134'), ROCKET(
				'\uf135'), MAXCDN('\uf136'), CHEVRON_CIRCLE_LEFT('\uf137'), CHEVRON_CIRCLE_RIGHT(
				'\uf138'), CHEVRON_CIRCLE_UP('\uf139'), CHEVRON_CIRCLE_DOWN(
				'\uf13a'), HTML5('\uf13b'), CSS3('\uf13c'), ANCHOR('\uf13d'), UNLOCK_O(
				'\uf13e'), BULLSEYE('\uf140'), ELLIPSIS_HORIZONTAL('\uf141'), ELLIPSIS_VERTICAL(
				'\uf142'), RSS_SQUARE('\uf143'), PLAY_CIRCLE('\uf144'), TICKET(
				'\uf145'), MINUS_SQUARE('\uf146'), MINUS_SQUARE_O('\uf147'), LEVEL_UP(
				'\uf148'), LEVEL_DOWN('\uf149'), CHECK_SQUARE('\uf14a'), PENCIL_SQUARE(
				'\uf14b'), EXTERNAL_LINK_SQUARE('\uf14c'), SHARE_SQUARE(
				'\uf14d'), COMPASS('\uf14e'), TOGGLE_DOWN('\uf150'), CARET_SQUARE_O_DOWN(
				'\uf150'), TOGGLE_UP('\uf151'), CARET_SQUARE_O_UP('\uf151'), TOGGLE_RIGHT(
				'\uf152'), CARET_SQUARE_O_RIGHT('\uf152'), EURO('\uf153'), EUR(
				'\uf153'), GBP('\uf154'), DOLLAR('\uf155'), USD('\uf155'), RUPEE(
				'\uf156'), INR('\uf156'), CNY('\uf157'), RMB('\uf157'), YEN(
				'\uf157'), JPY('\uf157'), RUBLE('\uf158'), ROUBLE('\uf158'), RUB(
				'\uf158'), WON('\uf159'), KRW('\uf159'), BITCOIN('\uf15a'), BTC(
				'\uf15a'), FILE('\uf15b'), FILE_TEXT('\uf15c'), SORT_ALPHA_ASC(
				'\uf15d'), SORT_ALPHA_DESC('\uf15e'), SORT_AMOUNT_ASC('\uf160'), SORT_AMOUNT_DESC(
				'\uf161'), SORT_NUMERIC_ASC('\uf162'), SORT_NUMERIC_DESC(
				'\uf163'), THUMBS_UP('\uf164'), THUMBS_DOWN('\uf165'), YOUTUBE_SQUARE(
				'\uf166'), YOUTUBE('\uf167'), XING('\uf168'), XING_SQUARE(
				'\uf169'), YOUTUBE_PLAY('\uf16a'), DROPBOX('\uf16b'), STACK_OVERFLOW(
				'\uf16c'), INSTAGRAM('\uf16d'), FLICKR('\uf16e'), ADN('\uf170'), BITBUCKET(
				'\uf171'), BITBUCKET_SQUARE('\uf172'), TUMBLR('\uf173'), TUMBLR_SQUARE(
				'\uf174'), LONG_ARROW_DOWN('\uf175'), LONG_ARROW_UP('\uf176'), LONG_ARROW_LEFT(
				'\uf177'), LONG_ARROW_RIGHT('\uf178'), APPLE('\uf179'), WINDOWS(
				'\uf17a'), ANDROID('\uf17b'), LINUX('\uf17c'), DRIBBBLE(
				'\uf17d'), SKYPE('\uf17e'), FOURSQUARE('\uf180'), TRELLO(
				'\uf181'), FEMALE('\uf182'), MALE('\uf183'), GITTIP('\uf184'), SUN_O(
				'\uf185'), MOON_O('\uf186'), ARCHIVE('\uf187'), BUG('\uf188'), VK(
				'\uf189'), WEIBO('\uf18a'), RENREN('\uf18b'), PAGELINES(
				'\uf18c'), STACK_EXCHANGE('\uf18d'), ARROW_CIRCLE_O_RIGHT(
				'\uf18e'), ARROW_CIRCLE_O_LEFT('\uf190'), TOGGLE_LEFT('\uf191'), CARET_SQUARE_O_LEFT(
				'\uf191'), DOT_CIRCLE_O('\uf192'), WHEELCHAIR('\uf193'), VIMEO_SQUARE(
				'\uf194'), TURKISH_LIRA('\uf195'), TRY('\uf195'), PLUS_SQUARE_O(
				'\uf196');

		private final Character character;

		private Icon(Character character) {
			this.character = character;
		}

		public Character getChar() {
			return character;
		}

		public String getIconName() {
			String str = "fa-";
			String name = name();
			String[] words = name.toLowerCase().split("_");
			for (String word : words) {
				str = str + word + "-";
			}
			str = str.substring(0, str.length() - 1);
			return str;
		}

		@Override
		public String toString() {
			return character.toString();
		}
	}
}