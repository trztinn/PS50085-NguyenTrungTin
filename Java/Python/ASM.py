import json
import os

FILE_PATH = "nhan_vien.json"


# ================== LỚP ĐỐI TƯỢNG ==================
class NhanVien:
    loai_nv = "Hành chính"

    def __init__(self, ma: str, ho_ten: str, luong: float):
        self.ma = ma.strip()
        self.ho_ten = ho_ten.strip()
        self.luong = float(luong)

    def get_thu_nhap(self) -> float:
        return self.luong

    def get_thue_tn(self) -> float:
        thu_nhap = self.get_thu_nhap()
        if thu_nhap < 9_000_000:
            return 0.0
        elif thu_nhap <= 15_000_000:
            return thu_nhap * 0.10
        else:
            return thu_nhap * 0.12

    def to_dict(self) -> dict:
        return {
            "loai": self.loai_nv,
            "ma": self.ma,
            "ho_ten": self.ho_ten,
            "luong": self.luong,
        }

    @classmethod
    def from_dict(cls, data: dict):
        loai = data.get("loai", "Hành chính")
        if loai == "Tiếp thị":
            return TiepThi(
                ma=data["ma"],
                ho_ten=data["ho_ten"],
                luong=data["luong"],
                doanh_so=data.get("doanh_so", 0.0),
                ti_le_hoa_hong=data.get("ti_le_hoa_hong", 0.0),
            )
        elif loai == "Trưởng phòng":
            return TruongPhong(
                ma=data["ma"],
                ho_ten=data["ho_ten"],
                luong=data["luong"],
                luong_trach_nhiem=data.get("luong_trach_nhiem", 0.0),
            )
        return cls(
            ma=data["ma"],
            ho_ten=data["ho_ten"],
            luong=data["luong"],
        )

    def hien_thi(self):
        print(
            f"[{self.loai_nv:<12}] Mã: {self.ma:<8} | Họ tên: {self.ho_ten:<22} | "
            f"Lương CB: {self.luong:>12,.0f} | Thu nhập: {self.get_thu_nhap():>12,.0f} | "
            f"Thuế TN: {self.get_thue_tn():>11,.0f}"
        )


class TiepThi(NhanVien):
    loai_nv = "Tiếp thị"

    def __init__(
        self,
        ma: str,
        ho_ten: str,
        luong: float,
        doanh_so: float,
        ti_le_hoa_hong: float,
    ):
        super().__init__(ma, ho_ten, luong)
        self.doanh_so = float(doanh_so)
        # Hỗ trợ nhập dạng phần trăm (vd: 5 -> 0.05) hoặc thập phân (vd: 0.05)
        self.ti_le_hoa_hong = (
            float(ti_le_hoa_hong) / 100.0
            if float(ti_le_hoa_hong) > 1
            else float(ti_le_hoa_hong)
        )

    def get_thu_nhap(self) -> float:
        return self.luong + self.doanh_so * self.ti_le_hoa_hong

    def to_dict(self) -> dict:
        data = super().to_dict()
        data.update(
            {
                "doanh_so": self.doanh_so,
                "ti_le_hoa_hong": self.ti_le_hoa_hong,
            }
        )
        return data

    def hien_thi(self):
        print(
            f"[{self.loai_nv:<12}] Mã: {self.ma:<8} | Họ tên: {self.ho_ten:<22} | "
            f"Lương CB: {self.luong:>12,.0f} | DS: {self.doanh_so:>12,.0f} | "
            f"HH: {self.ti_le_hoa_hong*100:>4.1f}% | Thu nhập: {self.get_thu_nhap():>12,.0f} | "
            f"Thuế TN: {self.get_thue_tn():>11,.0f}"
        )


class TruongPhong(NhanVien):
    loai_nv = "Trưởng phòng"

    def __init__(self, ma: str, ho_ten: str, luong: float, luong_trach_nhiem: float):
        super().__init__(ma, ho_ten, luong)
        self.luong_trach_nhiem = float(luong_trach_nhiem)

    def get_thu_nhap(self) -> float:
        return self.luong + self.luong_trach_nhiem

    def to_dict(self) -> dict:
        data = super().to_dict()
        data.update({"luong_trach_nhiem": self.luong_trach_nhiem})
        return data

    def hien_thi(self):
        print(
            f"[{self.loai_nv:<12}] Mã: {self.ma:<8} | Họ tên: {self.ho_ten:<22} | "
            f"Lương CB: {self.luong:>12,.0f} | Trách nhiệm: {self.luong_trach_nhiem:>11,.0f} | "
            f"Thu nhập: {self.get_thu_nhap():>12,.0f} | Thuế TN: {self.get_thue_tn():>11,.0f}"
        )


# ================== HÀM HỖ TRỢ & KIỂM TRA LỖI ==================
def nhap_so_thuc(prompt: str, min_val: float = 0.0, max_val: float | None = None) -> float:
    while True:
        try:
            val = float(input(prompt).strip())
            if val < min_val:
                print(f"Giá trị phải >= {min_val}. Vui lòng nhập lại!")
                continue
            if max_val is not None and val > max_val:
                print(f"Giá trị phải <= {max_val}. Vui lòng nhập lại!")
                continue
            return val
        except ValueError:
            print("Lỗi: Vui lòng nhập số hợp lệ!")


def nhap_chuoi_khong_rong(prompt: str) -> str:
    while True:
        s = input(prompt).strip()
        if s:
            return s
        print("Lỗi: Không được để trống!")


def tim_theo_ma(ds_nv: list[NhanVien], ma: str) -> NhanVien | None:
    ma_chuan = ma.strip().lower()
    for nv in ds_nv:
        if nv.ma.lower() == ma_chuan:
            return nv
    return None


# ================== THAO TÁC FILE (Y1, Y2) ==================
def luu_file(ds_nv: list[NhanVien], filename: str = FILE_PATH):
    try:
        with open(filename, "w", encoding="utf-8") as f:
            json.dump([nv.to_dict() for nv in ds_nv], f, ensure_ascii=False, indent=4)
        print(f"Đã lưu {len(ds_nv)} nhân viên vào file '{filename}'.")
    except OSError as e:
        print(f"Lỗi khi ghi file: {e}")


def doc_file(filename: str = FILE_PATH) -> list[NhanVien]:
    if not os.path.exists(filename):
        return []
    try:
        with open(filename, "r", encoding="utf-8") as f:
            raw_data = json.load(f)
        if not isinstance(raw_data, list):
            return []
        return [NhanVien.from_dict(item) for item in raw_data]
    except (OSError, json.JSONDecodeError, KeyError, ValueError) as e:
        print(f"Lỗi khi đọc file '{filename}': {e}")
        return []


# ================== CÁC CHỨC NĂNG Y1 - Y9 ==================
def y1_nhap_va_luu(ds_nv: list[NhanVien]):
    print("\n--- Y1: NHẬP DANH SÁCH NHÂN VIÊN ---")
    while True:
        print("Chọn loại nhân viên: 1. Hành chính | 2. Tiếp thị | 3. Trưởng phòng")
        loai = input("Lựa chọn của bạn (1-3): ").strip()
        if loai not in ("1", "2", "3"):
            print("Lựa chọn không hợp lệ, vui lòng chọn 1, 2 hoặc 3.")
            continue

        while True:
            ma = nhap_chuoi_khong_rong("Nhập mã nhân viên: ")
            if tim_theo_ma(ds_nv, ma) is not None:
                print(f"Mã '{ma}' đã tồn tại! Nhập mã khác.")
            else:
                break

        ho_ten = nhap_chuoi_khong_rong("Nhập họ và tên: ")
        luong = nhap_so_thuc("Nhập lương cơ bản: ", min_val=0)

        if loai == "1":
            nv = NhanVien(ma, ho_ten, luong)
        elif loai == "2":
            doanh_so = nhap_so_thuc("Nhập doanh số bán hàng: ", min_val=0)
            hh = nhap_so_thuc("Nhập tỉ lệ hoa hồng (vd: 5 hoặc 0.05): ", min_val=0)
            nv = TiepThi(ma, ho_ten, luong, doanh_so, hh)
        else:
            luong_tn = nhap_so_thuc("Nhập lương trách nhiệm: ", min_val=0)
            nv = TruongPhong(ma, ho_ten, luong, luong_tn)

        ds_nv.append(nv)
        print("Thêm nhân viên thành công!")

        tiep = input("Bạn có muốn nhập tiếp không? (y/n): ").strip().lower()
        if tiep != "y":
            break

    luu_file(ds_nv)


def y2_doc_va_xuat(ds_nv: list[NhanVien]):
    print("\n--- Y2: DANH SÁCH NHÂN VIÊN (TỪ FILE) ---")
    ds_tu_file = doc_file()
    if ds_tu_file:
        ds_nv.clear()
        ds_nv.extend(ds_tu_file)

    if not ds_nv:
        print("Danh sách nhân viên đang trống.")
        return

    for idx, nv in enumerate(ds_nv, start=1):
        print(f"{idx:>2}. ", end="")
        nv.hien_thi()


def y3_tim_theo_ma(ds_nv: list[NhanVien]):
    print("\n--- Y3: TÌM NHÂN VIÊN THEO MÃ ---")
    ma = nhap_chuoi_khong_rong("Nhập mã nhân viên cần tìm: ")
    nv = tim_theo_ma(ds_nv, ma)
    if nv:
        nv.hien_thi()
    else:
        print(f"Không tìm thấy nhân viên có mã '{ma}'.")


def y4_xoa_theo_ma(ds_nv: list[NhanVien]):
    print("\n--- Y4: XÓA NHÂN VIÊN THEO MÃ ---")
    ma = nhap_chuoi_khong_rong("Nhập mã nhân viên cần xóa: ")
    nv = tim_theo_ma(ds_nv, ma)
    if not nv:
        print(f"Không tìm thấy nhân viên có mã '{ma}'.")
        return

    nv.hien_thi()
    xac_nhan = input("Xác nhận xóa nhân viên này? (y/n): ").strip().lower()
    if xac_nhan == "y":
        ds_nv.remove(nv)
        print("Đã xóa nhân viên.")
        luu_file(ds_nv)
    else:
        print("Đã hủy thao tác xóa.")


def y5_cap_nhat_theo_ma(ds_nv: list[NhanVien]):
    print("\n--- Y5: CẬP NHẬT NHÂN VIÊN THEO MÃ ---")
    ma = nhap_chuoi_khong_rong("Nhập mã nhân viên cần cập nhật: ")
    nv = tim_theo_ma(ds_nv, ma)
    if not nv:
        print(f"Không tìm thấy nhân viên có mã '{ma}'.")
        return

    print("Thông tin hiện tại:")
    nv.hien_thi()
    print("(Nhấn Enter nếu muốn giữ nguyên giá trị cũ)")

    ten_moi = input(f"Họ tên mới [{nv.ho_ten}]: ").strip()
    if ten_moi:
        nv.ho_ten = ten_moi

    luong_str = input(f"Lương cơ bản mới [{nv.luong}]: ").strip()
    if luong_str:
        try:
            val = float(luong_str)
            if val >= 0:
                nv.luong = val
            else:
                print("Lương phải >= 0, giữ nguyên lương cũ.")
        except ValueError:
            print("Giá trị không hợp lệ, giữ nguyên lương cũ.")

    if isinstance(nv, TiepThi):
        ds_str = input(f"Doanh số mới [{nv.doanh_so}]: ").strip()
        if ds_str:
            try:
                val = float(ds_str)
                if val >= 0:
                    nv.doanh_so = val
            except ValueError:
                print("Giá trị không hợp lệ, giữ nguyên doanh số cũ.")

        hh_str = input(f"Tỉ lệ hoa hồng mới [{nv.ti_le_hoa_hong*100}%]: ").strip()
        if hh_str:
            try:
                val = float(hh_str)
                if val >= 0:
                    nv.ti_le_hoa_hong = val / 100.0 if val > 1 else val
            except ValueError:
                print("Giá trị không hợp lệ, giữ nguyên hoa hồng cũ.")

    elif isinstance(nv, TruongPhong):
        tn_str = input(f"Lương trách nhiệm mới [{nv.luong_trach_nhiem}]: ").strip()
        if tn_str:
            try:
                val = float(tn_str)
                if val >= 0:
                    nv.luong_trach_nhiem = val
            except ValueError:
                print("Giá trị không hợp lệ, giữ nguyên lương trách nhiệm cũ.")

    print("Cập nhật thành công!")
    luu_file(ds_nv)


def y6_tim_theo_khoang_luong(ds_nv: list[NhanVien]):
    print("\n--- Y6: TÌM NHÂN VIÊN THEO KHOẢNG THU NHẬP ---")
    min_tn = nhap_so_thuc("Nhập thu nhập tối thiểu: ", min_val=0)
    max_tn = nhap_so_thuc("Nhập thu nhập tối đa: ", min_val=min_tn)

    ket_qua = [nv for nv in ds_nv if min_tn <= nv.get_thu_nhap() <= max_tn]
    if not ket_qua:
        print(f"Không có nhân viên nào có thu nhập trong khoảng [{min_tn:,.0f}; {max_tn:,.0f}].")
        return

    print(f"Tìm thấy {len(ket_qua)} nhân viên:")
    for nv in ket_qua:
        nv.hien_thi()


def y7_sap_xep_theo_ten(ds_nv: list[NhanVien]):
    print("\n--- Y7: SẮP XẾP NHÂN VIÊN THEO HỌ VÀ TÊN (A-Z) ---")
    ds_nv.sort(key=lambda nv: nv.ho_ten.lower())
    for idx, nv in enumerate(ds_nv, start=1):
        print(f"{idx:>2}. ", end="")
        nv.hien_thi()


def y8_sap_xep_theo_thu_nhap(ds_nv: list[NhanVien]):
    print("\n--- Y8: SẮP XẾP NHÂN VIÊN THEO THU NHẬP (GIẢM DẦN) ---")
    ds_nv.sort(key=lambda nv: nv.get_thu_nhap(), reverse=True)
    for idx, nv in enumerate(ds_nv, start=1):
        print(f"{idx:>2}. ", end="")
        nv.hien_thi()


def y9_top_5_thu_nhap(ds_nv: list[NhanVien]):
    print("\n--- Y9: TOP 5 NHÂN VIÊN CÓ THU NHẬP CAO NHẤT ---")
    if not ds_nv:
        print("Danh sách nhân viên đang trống.")
        return
    top_5 = sorted(ds_nv, key=lambda nv: nv.get_thu_nhap(), reverse=True)[:5]
    for idx, nv in enumerate(top_5, start=1):
        print(f"Top {idx}: ", end="")
        nv.hien_thi()


# ================== MENU CHÍNH ==================
def menu():
    ds_nv = doc_file()
    while True:
        print("\n" + "=" * 55)
        print("   HỆ THỐNG QUẢN LÝ NHÂN SỰ TIỀN LƯƠNG - CÔNG TY RỒNG VIỆT")
        print("=" * 55)
        print("1. Nhập danh sách nhân viên & lưu file (Y1)")
        print("2. Đọc file & xuất danh sách nhân viên (Y2)")
        print("3. Tìm nhân viên theo mã (Y3)")
        print("4. Xóa nhân viên theo mã & cập nhật file (Y4)")
        print("5. Cập nhật thông tin nhân viên theo mã & lưu file (Y5)")
        print("6. Tìm nhân viên theo khoảng thu nhập (Y6)")
        print("7. Sắp xếp nhân viên theo họ và tên (Y7)")
        print("8. Sắp xếp nhân viên theo thu nhập (Y8)")
        print("9. Xuất 5 nhân viên có thu nhập cao nhất (Y9)")
        print("0. Thoát chương trình")
        print("=" * 55)

        chon = input("Chọn chức năng (0-9): ").strip()
        if chon == "1":
            y1_nhap_va_luu(ds_nv)
        elif chon == "2":
            y2_doc_va_xuat(ds_nv)
        elif chon == "3":
            y3_tim_theo_ma(ds_nv)
        elif chon == "4":
            y4_xoa_theo_ma(ds_nv)
        elif chon == "5":
            y5_cap_nhat_theo_ma(ds_nv)
        elif chon == "6":
            y6_tim_theo_khoang_luong(ds_nv)
        elif chon == "7":
            y7_sap_xep_theo_ten(ds_nv)
        elif chon == "8":
            y8_sap_xep_theo_thu_nhap(ds_nv)
        elif chon == "9":
            y9_top_5_thu_nhap(ds_nv)
        elif chon == "0":
            print("Tạm biệt!")
            break
        else:
            print("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 9!")


if __name__ == "__main__":
    menu()